//How will you implement Java IO classes to maintain patient records and generate medical reports?

package assess_12;

import java.io.*;

public class HospitalApp {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("patients.txt", true);

            fw.write("ID:1 Name:Gautam Disease:Fever\n");
            fw.write("ID:2 Name:Dinesh Disease:Diabetes\n");

            fw.close();

            BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
            String line;

            System.out.println("Patient Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}