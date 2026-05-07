//Create a menu-driven program for ATM operations:

package Day_2;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000;

        while (true) {
            System.out.println("\n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balance);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    balance += sc.nextDouble();
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    if (amt <= balance) balance -= amt;
                    else System.out.println("Insufficient balance");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}