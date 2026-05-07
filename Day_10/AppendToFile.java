//. Append Data to File Write a program to: 
//• Take user input • Append that data into an existing file without deleting previous content

package Day_10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendToFile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            
            FileWriter fw = new FileWriter("input.txt", true);

            System.out.println("Enter text to append into file:");
            String data = sc.nextLine();

            fw.write(data);
            fw.write("\n"); 

            fw.close();

            System.out.println("Data appended successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        sc.close();
    }
}