//Create a program that checks user role (Admin, User, Guest) and displays access permissions.


package Day_2;

import java.util.Scanner;

public class UserRole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter role (Admin/User/Guest): ");
        String role = sc.next().toLowerCase();

        switch (role) {
            case "admin": System.out.println("Full Access"); break;
            case "user": System.out.println("Limited Access"); break;
            case "guest": System.out.println("View Only"); break;
            default: System.out.println("Invalid Role");
        }
    }
}