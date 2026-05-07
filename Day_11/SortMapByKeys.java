//Sort a map by keys.

package Day_11;

import java.util.*;

public class SortMapByKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> map = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter key-value pairs:");

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            String value = sc.next();
            map.put(key, value);
        }

        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);

        System.out.println("Sorted Map by Keys:");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}