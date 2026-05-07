//How can Java File Handling be used to save product orders, invoices, and customer shipping details?

package assess_12;

import java.io.*;

public class EcommerceApp {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("orders.txt", true);

            fw.write("OrderID:101 Product:Laptop Price:50000 Address:Jamshedpur\n");
            fw.write("OrderID:102 Product:Phone Price:20000 Address:Ranchi\n");

            fw.close();

            System.out.println("Orders saved successfully!");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}