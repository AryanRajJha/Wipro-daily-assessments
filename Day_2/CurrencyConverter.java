//Write a program that converts currency based on user choice (e.g., INR to USD, INR to EUR, etc.).


package Day_2;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.INR to USD\n2.INR to EUR");
        int choice = sc.nextInt();

        System.out.print("Enter amount in INR: ");
        double amt = sc.nextDouble();

        switch (choice) {
            case 1: System.out.println("USD: " + (amt / 93)); break;
            case 2: System.out.println("EUR: " + (amt / 90)); break;
            default: System.out.println("Invalid choice");
        }
    }
}