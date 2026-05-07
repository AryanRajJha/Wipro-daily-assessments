//Count Specific Word in File 
//Write a program to count how many times a specific word (e.g., "Java") appears in a file.

package Day_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    public static void main(String[] args) {

        String wordToFind = "Java";   // word to search
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Split line into words
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {
                    if (word.equals(wordToFind)) {
                        count++;
                    }
                }
            }

            br.close();

            System.out.println("The word \"" + wordToFind + "\" appears " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}