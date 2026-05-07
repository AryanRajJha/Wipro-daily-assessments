package assess_6;

import java.util.Scanner;

class InvalidPinException extends Exception {
 public InvalidPinException(String message) {
     super(message);
 }
}

class ATM {
 private final int correctPin = 1234;

 void insertCard() {
     System.out.println("Card inserted successfully.");
 }

 void enterPin(int pin) throws InvalidPinException {
     if (pin != correctPin) {
         throw new InvalidPinException("Incorrect PIN entered!");
     }
     System.out.println("PIN verified successfully.");
 }
}

public class ATMMain {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     ATM atm = new ATM();

     try {
         atm.insertCard();

         System.out.print("Enter your PIN: ");
         int pin = sc.nextInt();

         atm.enterPin(pin);

         System.out.println("Access granted. You can proceed with transactions.");

     } catch (InvalidPinException e) {
         
         System.out.println("Exception: " + e.getMessage());

     } finally {
         
         System.out.println("Transaction logged. Thank you for using ATM.");
     }

     sc.close();
 }
}