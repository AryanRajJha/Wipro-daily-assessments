//12.Check whether a person is eligible for a loan (age + salary condition)

package Day_1;

import java.util.Scanner;

class Prob12_loan {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your monthly salary: ");
        double salary = sc.nextDouble();

        if (age >= 21 && age <= 60 && salary >= 25000)
            System.out.println("Eligible for Loan");
        else
            System.out.println("Not Eligible for Loan");

        sc.close();
    }
}