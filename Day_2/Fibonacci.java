//Write a program to print Fibonacci series up to N terms using a while loop.

package Day_2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter terms: ");
        int n = sc.nextInt();

        int a = 0, b = 1, i = 1;

        while (i <= n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
            i++;
        }
    }
}