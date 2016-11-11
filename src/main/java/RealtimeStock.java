/**
 * Created by kellykrawczyk on 11/11/16.
 */
import java.sql.*;
import java.util.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.text.SimpleDateFormat;

public class RealtimeStock extends TimerTask {

    private Stock[] stock;
    private double[] price;
    private Calendar cale;
    private long[] volume;

    public RealtimeStock() {

        stock = new Stock[DataReader.SYMBOLS.length];
        price = new double[DataReader.SYMBOLS.length];
        volume = new long[DataReader.SYMBOLS.length];

        for (int i = 0; i < DataReader.SYMBOLS.length; ++i) {
            this.stock[i] = YahooFinance.get(DataReader.SYMBOLS[i]);
        }
    }
    @Override
    public void run() {

        cale = Calendar.getInstance();
        java.util.Date taskTime = cale.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String nowTime = dateFormat.format(taskTime);

        try {

            Connection connection;

            connection = DriverManager.getConnection(DatabaseManager.URL + DatabaseManager.DATABASE_NAME, DatabaseManager.USER_NAME, DatabaseManager.PASSWORD);

            Statement statement = connection.createStatement();

            for (int i = 0; i < DataReader.SYMBOLS.length; ++i) {

                price[i] = stock[i].getQuote().getPrice().doubleValue();
                volume[i] = stock[i].getQuote().getVolume();

                //System.out.println(price[i] + " " + volume[i]);
                statement.executeUpdate("INSERT INTO StockRealtime VALUES ('" + DataReader.SYMBOLS[i] + "', '" + nowTime + "', " + price[i] + ", " + volume[i] + ")");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("database operation error.");
        }

    }


}
