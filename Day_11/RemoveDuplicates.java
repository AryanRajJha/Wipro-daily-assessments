//Remove duplicate characters from string.

package Day_11;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }

        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}