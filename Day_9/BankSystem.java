//Bank Account System
//Multiple threads deposit and withdraw from same account safely.


package Day_9;

import java.util.*;

class BankAccount {
    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " Deposited: " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " Withdraw: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance for " + Thread.currentThread().getName());
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        int bal = sc.nextInt();

        BankAccount acc = new BankAccount(bal);

        Thread t1 = new Thread(() -> {
            acc.deposit(500);
            acc.withdraw(300);
        }, "User1");

        Thread t2 = new Thread(() -> {
            acc.deposit(700);
            acc.withdraw(1000);
        }, "User2");

        t1.start();
        t2.start();
    }
}