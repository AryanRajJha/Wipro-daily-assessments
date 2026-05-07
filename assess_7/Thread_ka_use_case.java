package assess_7;

class MyThread extends Thread {

    public MyThread(String name) {
        super(name); 
    }

    @Override
    public void run() {
        System.out.println(getName() + " started.");

        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }

        System.out.println(getName() + " finished.");
    }
}

public class Thread_ka_use_case {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Before start:");
        System.out.println(t1.getName() + " isAlive: " + t1.isAlive());
        System.out.println(t2.getName() + " isAlive: " + t2.isAlive());

        t1.start();
        t2.start();

        try {
 
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println(t1.getName() + " completed. Now continuing main thread.");

        try {
        	
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("After execution:");
        System.out.println(t1.getName() + " isAlive: " + t1.isAlive());
        System.out.println(t2.getName() + " isAlive: " + t2.isAlive());

        System.out.println("Main thread finished.");
    }
}