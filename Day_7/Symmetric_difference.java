//Find elements present in either of the sets but not both.

package Day_7;

import java.util.*;

public class Symmetric_difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        System.out.print("Enter number of elements in Set 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }


        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);


        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);


        union.removeAll(intersection);

        System.out.println("Symmetric Difference: " + union);

        sc.close();
    }
}