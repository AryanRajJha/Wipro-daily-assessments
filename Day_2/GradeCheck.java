//Write a program that takes a grade (A, B, C, D, F) and displays the performance message.


package Day_2;

import java.util.Scanner;

public class GradeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grade: ");
        char grade = sc.next().toUpperCase().charAt(0);

        switch (grade) {
            case 'A': System.out.println("Excellent"); break;
            case 'B': System.out.println("Good"); break;
            case 'C': System.out.println("Average"); break;
            case 'D': System.out.println("Below Average"); break;
            case 'F': System.out.println("Fail"); break;
            default: System.out.println("Invalid Grade");
        }
    }
}