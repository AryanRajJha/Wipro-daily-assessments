//Buffered Reader Usage Write a Java program to read a file using 
//BufferedReader and print only those lines that contain the word "Java".

package Day_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadJavaLines {
    public static void main(String[] args) {

        try {
            
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            String line;

            System.out.println("Lines containing the word 'Java':");

            while ((line = br.readLine()) != null) {

                if (line.contains("Java")) {
                    System.out.println(line);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}