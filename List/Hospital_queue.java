package List;

import java.util.*;

class Patient1 {
    int id;
    String name;

    Patient1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class Hospital_queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Patient1> queue = new LinkedList<>();

        while (true) {
            System.out.println("\n    Hospital Queue System    ");
            System.out.println("1. Add Patient (Normal)");
            System.out.println("2. Add Patient (Emergency)");
            System.out.println("3. Remove Patients)");
            System.out.println("4. View All Patients");
            System.out.println("5. View First & Last Patient");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: 
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();

                    queue.addLast(new Patient1(id1, name1));
                    System.out.println("Patient added to queue.");
                    break;

                case 2: 
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();

                    queue.addFirst(new Patient1(id2, name2));
                    System.out.println("Emergency patient added at front!");
                    break;

                case 3: 
                	System.out.print("Enter Patient ID to remove: ");
                	int deleteId = sc.nextInt();

                	boolean removed = queue.removeIf(p -> p.id == deleteId);

                	if (removed) {
                	    System.out.println("Patient removed successfully!");
                	} else {
                	    System.out.println("Patient not found.");
                	}
                	break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("\nPatient Queue:");
                        for (Patient1 p : queue) {
                            p.display();
                        }
                    }
                    break;

                case 5: 
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("First Patient:");
                        queue.getFirst().display();

                        System.out.println("Last Patient:");
                        queue.getLast().display();
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}