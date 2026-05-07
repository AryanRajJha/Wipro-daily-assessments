//Alternate Printing (Even-Odd)
//Create two threads: one prints even numbers, another prints odd numbers (1–100) in
//sequence. 

package Day_9;

import java.util.*;

class NumberPrinter {
    private int number = 1;
    private int max;

    NumberPrinter(int max) {
        this.max = max;
    }

    public synchronized void printOdd() {
        while (number <= max) {
            if (number % 2 == 0) {
                try { wait(); } catch (Exception e) {}
            } else {
                System.out.println("Odd: " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= max) {
            if (number % 2 != 0) {
                try { wait(); } catch (Exception e) {}
            } else {
                System.out.println("Even: " + number);
                number++;
                notify();
            }
        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit: ");
        int n = sc.nextInt();

        NumberPrinter obj = new NumberPrinter(n);

        Thread t1 = new Thread(() -> obj.printOdd());
        Thread t2 = new Thread(() -> obj.printEven());

        t1.start();
        t2.start();
    }
}