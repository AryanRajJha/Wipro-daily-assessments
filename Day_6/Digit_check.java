//3.Check if character is a Digit

package Day_6;

import java.util.Scanner;

public class Digit_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (Character.isDigit(ch)) {
            System.out.println("It is a digit.");
        } else {
            System.out.println("Not a digit.");
        }

        sc.close();
    }
}