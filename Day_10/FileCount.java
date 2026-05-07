//Write a Java program to read a text file and count: • Number of lines • Number of words • Number of characters

package Day_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCount {
    public static void main(String[] args) {
        int lines = 0;
        int words = 0;
        int characters = 0;

        try {
            
            File file = new File("input.txt");

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines++;

                characters += line.length();

                if (!line.isEmpty()) {
                    String[] wordList = line.trim().split("\\s+");
                    words += wordList.length;
                }
            }

            sc.close();

            System.out.println("Number of Lines: " + lines);
            System.out.println("Number of Words: " + words);
            System.out.println("Number of Characters: " + characters);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}