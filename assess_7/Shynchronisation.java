package assess_7;

class FoodDelivery extends Thread {
    String taskName;


    static Object lock = new Object();

    FoodDelivery(String name) {
        this.taskName = name;
    }

    public void run() {

        synchronized(lock) {
            System.out.println(taskName + " started");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }

            System.out.println(taskName + " completed");
        }
    }
}w

public class Shynchronisation {
    public static void main(String[] args) throws InterruptedException {

        FoodDelivery order = new FoodDelivery("Order Processing");
        FoodDelivery kitchen = new FoodDelivery("Kitchen Processing");
        FoodDelivery delivery = new FoodDelivery("Delivery Processing");

        order.setPriority(Thread.MAX_PRIORITY);
        kitchen.setPriority(Thread.NORM_PRIORITY);
        delivery.setPriority(Thread.MIN_PRIORITY);

        order.start();
        kitchen.start();

        System.out.println("Is order Alive? " + order.isAlive());

        order.join();
        kitchen.join();

        delivery.start();
        delivery.join();

        System.out.println("A");
    }
}