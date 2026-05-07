//How can Java File Handling help in storing restaurant menus, customer orders, and delivery logs?

package assess_12;

import java.io.*;

public class FoodDeliveryApp {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("order.txt", true);

            fw.write("Order: Burger x2 | Customer: Aryan | Status: Delivered\n");
            fw.write("Order: Pizza x1 | Customer: Ravi | Status: Pending\n");

            fw.close();

            System.out.println("Delivery logs saved!");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}