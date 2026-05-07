//2. Check whether a number is even or odd 

package Day_1;

import java.util.Scanner;

class Prob2_oddEven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");

        sc.close();
    }
}