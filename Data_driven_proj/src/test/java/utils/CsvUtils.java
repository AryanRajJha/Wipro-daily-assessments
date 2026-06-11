package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static Object[][] getCsvData(String filePath)
            throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new FileReader(filePath));

        List<Object[]> list =
                new ArrayList<>();

        String line;

        br.readLine();

        while((line = br.readLine()) != null) {

            String[] data =
                    line.split(",");

            list.add(data);
        }

        br.close();

        Object[][] result =
                new Object[list.size()][];

        for(int i = 0; i < list.size(); i++) {

            result[i] = list.get(i);
        }

        return result;
    }
}