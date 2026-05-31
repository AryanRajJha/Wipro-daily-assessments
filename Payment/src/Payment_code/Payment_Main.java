//Develop payment system using interface and default method.

package Payment_code;

import java.util.Scanner;

interface Payment {

    void pay(double amount);

    default void processTransaction(double amount) {
        System.out.println("Processing payment of ₹" + amount);
    }

    default boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }
        return true;
    }

    static void paymentInfo() {
        System.out.println("Secure Payment System");
    }
}

class UPIPayment implements Payment {

    private String upiId;

    UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public void pay(double amount) {
        if (validateAmount(amount) && upiId.contains("@")) {
            processTransaction(amount);
            System.out.println("Paid ₹" + amount + " via UPI (" + upiId + ")");
        } else {
            System.out.println("UPI Payment Failed");
        }
    }
}

class CardPayment implements Payment {

    private String cardNumber;

    CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        if (validateAmount(amount) && cardNumber.length() == 12) {
            processTransaction(amount);
            System.out.println("Paid ₹" + amount + " using Card");
        } else {
            System.out.println("Card Payment Failed");
        }
    }
}

class NetBanking implements Payment {

    private String bankName;

    NetBanking(String bankName) {
        this.bankName = bankName;
    }

    public void pay(double amount) {
        if (validateAmount(amount)) {
            processTransaction(amount);
            System.out.println("Paid ₹" + amount + " via Net Banking (" + bankName + ")");
        } else {
            System.out.println("Net Banking Failed");
        }
    }
}

public class Payment_Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Payment.paymentInfo();

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Net Banking");

        int choice = sc.nextInt();

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();

        Payment payment = null;

        switch (choice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                String upi = sc.next();
                payment = new UPIPayment(upi);
                break;

            case 2:
                System.out.print("Enter Card Number: ");
                String card = sc.next();
                payment = new CardPayment(card);
                break;

            case 3:
                System.out.print("Enter Bank Name: ");
                String bank = sc.next();
                payment = new NetBanking(bank);
                break;

            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        payment.pay(amount);

        sc.close();
    }
}