package Interface_wala_package;

import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new CalculatorImpl();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        calc.divide(a, b);

        sc.close();
    }
}
