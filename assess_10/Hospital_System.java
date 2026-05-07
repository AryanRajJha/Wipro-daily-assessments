package assess_10;

import java.util.*;


class Patient implements Comparable<Patient> {
 int id;
 String name;

 Patient(int id, String name) {
     this.id = id;
     this.name = name;
 }


 public int compareTo(Patient p) {
     return this.id - p.id;
 }

 
 public void display() {
     System.out.println("ID: " + id + ", Name: " + name);
 }
}

public class Hospital_System {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);


     TreeSet<Patient> patients = new TreeSet<>();

     int choice;

     do {
         System.out.println("\n1. Add Patient");
         System.out.println("2. View Patients");
         System.out.println("3. Exit");
         System.out.print("Enter choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter Patient ID: ");
                 int id = sc.nextInt();
                 sc.nextLine(); 

                 System.out.print("Enter Patient Name: ");
                 String name = sc.nextLine();

                 Patient newPatient = new Patient(id, name);

                 
                 if (patients.contains(newPatient)) {
                     System.out.println("ID already registered");
                     System.out.println("Already registered");
                 } else {
                     patients.add(newPatient);
                     System.out.println("Patient added to the system");
                 }
                 break;

             case 2:
                 if (patients.isEmpty()) {
                     System.out.println("No patients registered.");
                 } else {
                     System.out.println("\nList of Registered Patients:");
                     for (Patient p : patients) {
                         p.display();
                     }
                 }
                 break;

             case 3:
                 System.out.println("Exiting...");
                 break;

             default:
                 System.out.println("Invalid choice!");
         }

     } while (choice != 3);

     sc.close();
 }
}