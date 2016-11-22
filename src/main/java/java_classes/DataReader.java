package java_classes; /**
 * Created by kellykrawczyk on 11/21/16.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    public ArrayList symbols;
    public ArrayList<ArrayList<ArrayList<String>>> allStocks;
    public ArrayList<stockData> symbolData;


    public DataReader() throws IOException {

        symbols = new ArrayList();
        allStocks = new ArrayList<ArrayList<ArrayList<String>>>();
        symbolData = new ArrayList<stockData>();

        BufferedReader buf = new BufferedReader(new FileReader("/Users/kellykrawczyk/Saul_Class_Projects/data/stocks/finance.csv"));

        String line="";
        while ((line = buf.readLine()) != null) {

            String csvSplitBy = ",";

            ArrayList singleStock = new ArrayList<stockData>()
                    ;
            String[] row = line.split(csvSplitBy);

            if (row.length > 0){

                while (true){

                    String n = row[0];
                    float m50 = Float.parseFloat(row[1]);
                    float m200 = Float.parseFloat(row[2]);
                    float pr = Float.parseFloat(row[3]);
                    float pb = Float.parseFloat(row[4]);
                    float eb = Float.parseFloat(row[5]);
                    float pg = Float.parseFloat(row[6]);


                    stockData comp = new stockData(n, m50, m200, pr, pb, eb, pg);
                    symbolData.add(comp);
                }




            }
        }



    }








    public static void main(String[] args) throws IOException
    {

        DataReader comp = new DataReader();


    }
}


