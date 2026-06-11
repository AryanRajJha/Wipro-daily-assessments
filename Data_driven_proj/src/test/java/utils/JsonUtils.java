package utils;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static Object[][] getJsonData(String filePath)
            throws Exception {

        ObjectMapper mapper =
                new ObjectMapper();

        JsonNode users =
                mapper.readTree(new File(filePath));

        Object[][] data =
                new Object[users.size()][2];

        for(int i = 0; i < users.size(); i++) {

            data[i][0] =
                    users.get(i)
                    .get("username")
                    .asText();

            data[i][1] =
                    users.get(i)
                    .get("password")
                    .asText();
        }

        return data;
    }
}