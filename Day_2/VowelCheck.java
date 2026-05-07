//Write a program that takes a character as input and checks whether it is a vowel or consonant using
//switch-case.

package Day_2;

import java.util.Scanner;

public class VowelCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter character: ");
        char ch = sc.next().toLowerCase().charAt(0);

        switch (ch) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println("Vowel");
                break;
            default:
                System.out.println("Consonant");
        }
    }
}
