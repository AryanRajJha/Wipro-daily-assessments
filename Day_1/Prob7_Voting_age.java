//7. Check eligibility for voting based on age 

package Day_1;

import java.util.Scanner;

class Prob7_Voting_age {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18)
            System.out.println("Eligible to vote");
        else
            System.out.println("Not eligible to vote");

        sc.close();
    }
}