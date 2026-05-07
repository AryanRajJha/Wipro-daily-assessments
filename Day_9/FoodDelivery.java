//Online Food Delivery System
//Multiple orders processed by limited delivery agents (thread pool)

package Day_9;

import java.util.*;
import java.util.concurrent.*;

class Order implements Runnable {
    private int orderId;

    Order(int orderId) {
        this.orderId = orderId;
    }

    public void run() {
        System.out.println("Processing Order: " + orderId +
                " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        System.out.println("Completed Order: " + orderId);
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();

        System.out.print("Enter number of delivery agents: ");
        int agents = sc.nextInt();

        ExecutorService pool = Executors.newFixedThreadPool(agents);

        for (int i = 1; i <= n; i++) {
            pool.execute(new Order(i));
        }

        pool.shutdown();
    }
}