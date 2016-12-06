package Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisneyReader {

    public List<String> disneyData;


    public DisneyReader(String dataFile) {

        disneyData = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));

            String str;
            while ((str = br.readLine()) != null) {
                disneyData.add(str);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
