package datareader;

import java.util.*;

public class DataReader {

    public static final int REALTIME_STOCK_INTERVAL = 5;
    public static final int HISTORICAL_STOCK_INTERVAL = 24 * 60 * 60;
    public static final String[] SYMBOLS = {"GOOG", "YHOO", "AAPL", "FB", "MSFT", "AMZN", "SNE", "WMT", "CAJ", "TWTR"};
    private HistoricalStock historicalStock;
    private RealtimeStock realtimeStock;

    private SVM svm;


    private Timer realtimeStockTimer;
    private Timer historicalStockTimer;

    public DataReader() {

        realtimeStockTimer = new Timer();
        realtimeStock = new RealtimeStock();
        realtimeStockTimer.schedule(realtimeStock, 0, REALTIME_STOCK_INTERVAL * 1000);

        historicalStockTimer = new Timer();
        historicalStock = new HistoricalStock(1);
        historicalStockTimer.schedule(historicalStock, 0, HISTORICAL_STOCK_INTERVAL * 1000);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {

        }


        svm = new SVM();
        svm.trainWithHistory();



    }

    public static void main(String[] args) {
        DataReader stockForecaster = new DataReader();
    }

}