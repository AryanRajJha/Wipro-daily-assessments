package Assessments;

import java.util.Scanner;

interface Payment {
    void pay(double amount);

    default void generateReceipt(double amount) {
        System.out.println("Receipt: Payment of Rs." + amount + " successful.");
    }

    static void paymentInfo() {
        System.out.println("Available Methods: Credit Card | Debit Card | UPI");
    }
}

class CreditCardPayment implements Payment {
    String cardNumber;
    int pin;

    CreditCardPayment(String cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public void pay(double amount) {
        System.out.println("Processing Credit Card...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}

class DebitCardPayment implements Payment {
    String cardNumber;
    int pin;

    DebitCardPayment(String cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public void pay(double amount) {
        System.out.println("Processing Debit Card...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Paid Rs." + amount + " using Debit Card");
    }
}

class UpiPayment implements Payment {
    String upiId;
    int pin;

    UpiPayment(String upiId, int pin) {
        this.upiId = upiId;
        this.pin = pin;
    }

    public void pay(double amount) {
        System.out.println("Processing UPI...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Paid Rs." + amount + " using UPI");
    }
}

public class PaymentApp {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            Payment.paymentInfo();

            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");

            int choice = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            Payment p = null;

            if (choice == 1) {
                System.out.print("Enter Card Number: ");
                String card = sc.next();
                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                p = new CreditCardPayment(card, pin);

            } else if (choice == 2) {
                System.out.print("Enter Card Number: ");
                String card = sc.next();
                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                p = new DebitCardPayment(card, pin);

            } else if (choice == 3) {
                System.out.print("Enter UPI ID: ");
                String upi = sc.next();
                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                p = new UpiPayment(upi, pin);

            } else {
                System.out.println("Invalid Choice!");
            }

            if (p != null) {
                p.pay(amount);
                p.generateReceipt(amount);
            }
        }
    }
}