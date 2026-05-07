//10.Check whether a number is zero, positive, or negative

package Day_1;

import java.util.Scanner;

class Prob10_check_num_is_zeroOrposOrneg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num > 0)
            System.out.println("Positive");
        else if (num < 0)
            System.out.println("Negative");
        else
            System.out.println("Zero");

        sc.close();
    }
}