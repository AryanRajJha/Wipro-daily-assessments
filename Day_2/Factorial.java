//Write a program to calculate the factorial of a given number using a while loop.


package Day_2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int fact = 1, i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        System.out.println("Factorial = " + fact);
    }
}
