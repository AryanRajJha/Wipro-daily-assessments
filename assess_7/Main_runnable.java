package assess_7;

class OrderProcessing implements Runnable {
 public void run() {
     System.out.println("Order is being processed...");
 }
}


class PaymentProcessing implements Runnable {
 public void run() {
     System.out.println("Payment is being processed...");
 }
}


class NotificationService implements Runnable {
 public void run() {
     System.out.println("Notification sent to user...");
 }
}

public class Main_runnable {
 public static void main(String[] args) {

     
     Runnable order = new OrderProcessing();
     Runnable payment = new PaymentProcessing();
     Runnable notification = new NotificationService();

    
     Thread t1 = new Thread(order);
     Thread t2 = new Thread(payment);
     Thread t3 = new Thread(notification);

     
     t1.start();
     t2.start();
     t3.start();
 }
}