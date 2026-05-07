//13.Check whether a number is divisible by 3 or 7

package Day_1;

import java.util.Scanner;

class Prob13_divisible_by_3_or_9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 3 == 0 || num % 7 == 0)
            System.out.println("Number is divisible by 3 or 7");
        else
            System.out.println("Number is NOT divisible by 3 or 7");

        sc.close();
    }
}