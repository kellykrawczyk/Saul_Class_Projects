package Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisneyReader {

    //public ArrayList<ArrayList<Float>> disneyAll;
    //public ArrayList<DisneyStock> disneyData;
    public List<String> disneyData;


    public DisneyReader(String dataFile) {

        disneyData = new ArrayList<String>();
        //disneyAll = new ArrayList<ArrayList<Float>>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));

            String str;
            while ((str = br.readLine()) != null) {
                disneyData.add(str);
            }
            br.close();
        } catch (Exception e) {
        }

        /*BufferedReader reader = new BufferedReader(new FileReader("/Users/kellykrawczyk/Saul_Class_Projects/data/newdata.csv"));

        String line = "";

        while ((line = reader.readLine()) != null) {

            if (line.substring(0,4).equals("Date")) {
                //skips first line with headers
            }

            else {

                String splitData = ",";

                ArrayList innerData = new ArrayList<Float>();

                String[] row = line.split(splitData);

                String d = row[0];
                float b = Float.parseFloat(row[1]);
                float td = Float.parseFloat(row[2]);
                float so = Float.parseFloat(row[3]);
                float c_ncwc = Float.parseFloat(row[4]);
                float ce = Float.parseFloat(row[5]);
                float ie = Float.parseFloat(row[6]);
                float ebit = Float.parseFloat(row[7]);
                float oi = Float.parseFloat(row[8]);
                float evcf = Float.parseFloat(row[9]);
                float ebitda = Float.parseFloat(row[10]);
                float r = Float.parseFloat(row[11]);
                float oe = Float.parseFloat(row[12]);
                float rv = Float.parseFloat(row[13]);
                float ncwv = Float.parseFloat(row[14]);
                float tl = Float.parseFloat(row[15]);
                float mc = Float.parseFloat(row[16]);
                float ni = Float.parseFloat(row[17]);
                float v = Float.parseFloat(row[18]);
                float eps = Float.parseFloat(row[19]);
                float best_eps = Float.parseFloat(row[20]);

                DisneyStock disney = new DisneyStock(d, b, td, so, c_ncwc, ce, ie, ebit, oi, evcf, ebitda, r, oe, rv, ncwv, tl, mc, ni, v, eps, best_eps);
                disney.initializeDisney();
                disneyData.add(disney);


            }
        }
    }

    public static void main(String[] args) throws IOException {

        DisneyReader dis = new DisneyReader();
        dis.disneyData.get(3).initializeDisney();

    }*/
    }

}
