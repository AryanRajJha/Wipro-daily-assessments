package List;

import java.util.*;

class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class PatientManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        while (true) {
            System.out.println("\n   Patient Management System    ");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Delete Patient by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    patients.add(new Patient(id, name, age));
                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        System.out.println("\nPatient List:");
                        for (Patient p : patients) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;

                    for (Patient p : patients) {
                        if (p.name.equalsIgnoreCase(searchName)) {
                            p.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = patients.removeIf(p -> p.id == deleteId);

                    if (removed) {
                        System.out.println("Patient deleted successfully!");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;


                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}