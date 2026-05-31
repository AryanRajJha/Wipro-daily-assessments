package Abstract_class_bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = null;

        System.out.println("Choose Bank: 1. SBI  2. HDFC  3. ICICI");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                bank = new SBI();
                break;
            case 2:
                bank = new HDFC();
                break;
            case 3:
                bank = new ICICI();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("Interest Rate: " + bank.getInterestRate() + "%");

        sc.close();
    }
}