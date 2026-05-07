//Print A B C in Sequence
//Three threads print A, B, C repeatedly in order (ABCABC…)

package Day_9;

import java.util.*;

class ABCPrinter {
    private int turn = 0;
    private int repeat;

    ABCPrinter(int repeat) {
        this.repeat = repeat;
    }

    public synchronized void printA() {
        for (int i = 0; i < repeat; i++) {
            while (turn != 0) {
                try { wait(); } catch (Exception e) {}
            }
            System.out.print("A ");
            turn = 1;
            notifyAll();
        }
    }

    public synchronized void printB() {
        for (int i = 0; i < repeat; i++) {
            while (turn != 1) {
                try { wait(); } catch (Exception e) {}
            }
            System.out.print("B ");
            turn = 2;
            notifyAll();
        }
    }

    public synchronized void printC() {
        for (int i = 0; i < repeat; i++) {
            while (turn != 2) {
                try { wait(); } catch (Exception e) {}
            }
            System.out.print("C ");
            turn = 0;
            notifyAll();
        }
    }
}

public class ABCThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter repetitions: ");
        int n = sc.nextInt();

        ABCPrinter obj = new ABCPrinter(n);

        new Thread(() -> obj.printA()).start();
        new Thread(() -> obj.printB()).start();
        new Thread(() -> obj.printC()).start();
    }
}