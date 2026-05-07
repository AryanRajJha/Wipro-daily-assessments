package assess_10;

import java.util.*;

public class merge_list {
    public static void main(String[] args) {

        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("Aryan", "Gautam", "Anand","Dinesh","Kaushik"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("Shanu", "Eklavya", "Prince", "Ashish","Kaushik"));

        Set<String> set = new LinkedHashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        LinkedList<String> result = new LinkedList<>(set);

        System.out.println(result);
    }
}