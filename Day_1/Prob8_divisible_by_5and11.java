//8. Check whether a number is divisible by 5 and 11 

package Day_1;

import java.util.Scanner;

class Prob8_divisible_by_5and11
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 5 == 0 && num % 11 == 0)
            System.out.println("Number is divisible by both 5 and 11");
        else
            System.out.println("Number is NOT divisible by both 5 and 11");

        sc.close();
    }
}