package kellykrawczyk.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 * Created by kellykrawczyk on 12/1/16.
 */

public class DisneyReader {

    public ArrayList<ArrayList<String>> disneyAll;
    public ArrayList<DisneyStock> disneyData;

    public DisneyReader() throws IOException {

        disneyData = new ArrayList<DisneyStock>();
        disneyAll = new ArrayList<ArrayList<String>>();

        BufferedReader reader = new BufferedReader(new FileReader("/Users/kellykrawczyk/Saul_Class_Projects/data/stocks.test"));

        String line = "";

        while ((line = reader.readLine()) != null) {

            if (line.substring(0,4).equals("Date")) {
                //skips first line with headers
            }

            else {

                String splitData = ",";

                ArrayList innerData = new ArrayList<DisneyStock>();

                String[] row = line.split(splitData);

                String d = row[0];
                float eps = Float.parseFloat(row[1]);
                float b = Float.parseFloat(row[2]);
                float td = Float.parseFloat(row[3]);
                float so = Float.parseFloat(row[4]);
                float c_ncwc = Float.parseFloat(row[5]);
                float ce = Float.parseFloat(row[6]);
                float ie = Float.parseFloat(row[7]);
                float ebit = Float.parseFloat(row[8]);
                float oi = Float.parseFloat(row[9]);
                float evcf = Float.parseFloat(row[10]);
                float ebitda = Float.parseFloat(row[11]);
                float r = Float.parseFloat(row[12]);
                float oe = Float.parseFloat(row[13]);
                float rv = Float.parseFloat(row[14]);
                float ncwv = Float.parseFloat(row[15]);
                float tl = Float.parseFloat(row[16]);
                float mc = Float.parseFloat(row[17]);
                float ni = Float.parseFloat(row[18]);
                float v = Float.parseFloat(row[19]);
                String pred = (row[20]);

                DisneyStock disney = new DisneyStock(d, eps, b, td, so, c_ncwc, ce, ie, ebit, oi, evcf, ebitda, r, oe, rv, ncwv, tl, mc, ni, v, pred);
                disney.initializeDisney();
                disneyData.add(disney);


            }
        }
    }

    public static void main(String[] args) throws IOException {

        DisneyReader dis = new DisneyReader();
        dis.disneyData.get(1).initializeDisney();
    }


}
