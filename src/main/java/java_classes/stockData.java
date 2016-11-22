package java_classes;

/**
 * Created by kellykrawczyk on 11/21/16.
 */


public class stockData {

    public String name;
    public float MA_50;
    public float MA_200;
    public float PER;
    public float PBV;
    public float EBITDA;
    public float PEG;

    //decision = 1 -> BUY
    //decision = -1 -> SELL
    //decision = 0 -> neither buy nor sell
    public float DECISION;

    //ticker = + -> BUY
    //ticker = - ->SELL
    public String TICKER = null;

    //constructor
    public stockData(String n, float ma50, float ma200, float per, float pbv, float ebitoda, float peg) {

        name = n;
        MA_50 = ma50;
        MA_200 = ma200;
        PER = per;
        PBV = pbv;
        EBITDA = ebitoda;
        PEG = peg;


        if (MA_50 > MA_200) {
            DECISION = 1;
        } else {
            DECISION = 0;
        }

        if (PER < .15) {
            DECISION = 1;
        } else {
            DECISION = 0;
        }

        if (PBV > 1) {
            DECISION = 1;
        } else {
            DECISION = 0;
        }

        if (MA_50 - MA_200 > 0 && EBITDA > MA_50) {
            DECISION = -1;
        } else {
            DECISION = 0;
        }

        if (PEG < 1) {
            DECISION = 1;
        } else {
            DECISION = 0;
        }

        if (DECISION > 0) {
            TICKER = "+";
        } else {
            TICKER = "-";
        }

    }

}
