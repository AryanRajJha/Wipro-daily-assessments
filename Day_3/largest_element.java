//3. Find largest element in each row.


package Day_3;

import java.util.*;

public class largest_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int r = sc.nextInt();
        System.out.print("Enter columns: ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r; i++) {
            int max = arr[i][0];
            for (int j = 1; j < c; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println("Largest in row " + i + ": " + max);
        }
    }
}