package assess_7;
class Payment implements Runnable {
    public void run() {
        System.out.println("Payment processing...");
        try { Thread.sleep(2000); } catch(Exception e) {}
        System.out.println("Payment successful");
    }
}
class Order implements Runnable {
    public void run() {
        System.out.println("Order processing...");
        try { Thread.sleep(1500); } catch(Exception e) {}
        System.out.println("Order confirmed");
    }
}
class Notification implements Runnable {
    public void run() {
        System.out.println("Sending notification...");
        try { Thread.sleep(1000); } catch(Exception e) {}
        System.out.println("Notification sent");
    }
}
public class FoodApp {
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new Payment());
        Thread t2 = new Thread(new Order());
        Thread t3 = new Thread(new Notification());

        t1.start();
        t1.join();   
        t2.start();
        t2.join();  
        t3.start();
    }
}