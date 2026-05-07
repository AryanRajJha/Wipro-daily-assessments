//6. Check whether a character is a vowel or consonant

package Day_1;

import java.util.Scanner;

class Prob6_vowelConsonant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        ch = Character.toLowerCase(ch);

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                System.out.println("Vowel");
            else
                System.out.println("Consonant");
        } else {
            System.out.println("Invalid input (not an alphabet)");
        }

        sc.close();
    }
}