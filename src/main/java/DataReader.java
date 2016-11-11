/**
 * Created by kellykrawczyk on 11/11/16.
 */
import java.util.*;

public class DataReader {
    public static final int REALTIME_STOCK_INTERVAL = 5;
    public static final String[] SYMBOLS = {"GOOG", "YHOO", "AAPL", "FB", "MSFT", "AMZN", "SNE", "WMT", "CAJ", "TWTR"};

    private List<List<Double>> Data;
    private List<List<String>> Date;
    private List<List<String>> BAYAction;
    private double BAYBalance;
    private int[] BAYNumStock;

    private RealtimeStock realtimeStock;
    private Test bayesianPredictor;

    private Timer realtimeStockTimer;

    public DataReader() {

        realtimeStockTimer = new Timer();
        realtimeStock = new RealtimeStock();
        realtimeStockTimer.schedule(realtimeStock, 0, REALTIME_STOCK_INTERVAL * 1000);

        bayesianPredictor = new Test();
        bayesianPredictor.ShortTermPredictAll();
        bayesianPredictor.LongTermPredictAll();

        Data = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            Data.add(new ArrayList());
        }
        Date = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            Date.add(new ArrayList());
        }
        BAYAction = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            BAYAction.add(new ArrayList());
        }

        BAYBalance = 1000000;

        BAYNumStock = new int[10];

    }

    public static void main(String[] args) {
        DataReader stockForecaster = new DataReader();
    }




}
