package assess_5;

import java.util.Scanner;

abstract class Payment {
  
    public final void processPayment(double amount) {
        validateAmount(amount);
        authenticate();
        makePayment(amount);
        System.out.println("Payment processed successfully.\n");
    }

    
    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
    }

   
    private void authenticate() {
        System.out.println("Authenticating payment...");
    }

  
    protected abstract void makePayment(double amount);
}


class CreditCardPayment extends Payment {
    @Override
    protected void makePayment(double amount) {
        System.out.println("₹" + amount + " paid using Credit Card");
    }
}


class UpiPayment extends Payment {
    @Override
    protected void makePayment(double amount) {
        System.out.println("₹" + amount + " paid using UPI");
    }
}

public class PaymentProcessor {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter payment amount: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid input! Enter a numeric value.");
                return;
            }

            double amount = sc.nextDouble();

            System.out.println("Choose payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");

            int choice = sc.nextInt();

            Payment payment;

            switch (choice) {
                case 1:
                    payment = new CreditCardPayment();
                    break;
                case 2:
                    payment = new UpiPayment();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            payment.processPayment(amount);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}