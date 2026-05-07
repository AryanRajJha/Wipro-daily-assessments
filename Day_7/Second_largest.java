//Find the second largest element in a List<Integer>.

package Day_7;

import java.util.*;

public class Second_largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Not enough elements");
            sc.close();
            return;
        }

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

    
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all values may be same)");
        } else {
            System.out.println("Second Largest: " + secondLargest);
        }

        sc.close();
    }
}