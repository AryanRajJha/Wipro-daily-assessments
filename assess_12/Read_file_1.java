package assess_12;

import java.io.FileReader;
import java.io.IOException;

public class Read_file_1 {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("renu.txt");
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);  
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}