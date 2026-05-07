//How will you use Java IO File Handling to store customer transaction history and read account details from files?

package assess_12;

import java.io.*;
import java.util.*;

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class BankingApp {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("transactions.txt", true);

            fw.write("Deposit: 5000\n");
            fw.write("Withdraw: 2000\n");
            fw.close();

         
            BufferedReader br = new BufferedReader(new FileReader("transactions.txt"));
            String line;

            System.out.println("Transaction History:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}