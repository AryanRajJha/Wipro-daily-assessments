//Write a program to check whether a number is a palindrome using a while loop.


package Day_2;

import java.util.Scanner;

public class Pallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int original = num, rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        if (original == rev)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}