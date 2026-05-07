//Write a program to check whether a number is prime using a while loop.


package Day_2;

import java.util.Scanner;

public class PrimeNumCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int i = 2;
        boolean isPrime = true;

        while (i <= num / 2) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }

        if (num <= 1) isPrime = false;

        if (isPrime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");
    }
}