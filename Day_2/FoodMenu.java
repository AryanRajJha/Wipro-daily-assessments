//Create a program where user selects food item number and the program displays item name and
//price.


package Day_2;

import java.util.Scanner;

public class FoodMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item number (1-3): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: System.out.println("Pizza - ₹200"); break;
            case 2: System.out.println("Burger - ₹100"); break;
            case 3: System.out.println("Pasta - ₹150"); break;
            default: System.out.println("Invalid choice");
        }
    }
}