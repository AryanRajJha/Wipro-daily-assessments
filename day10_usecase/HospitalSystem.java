package day10_usecase;

import java.util.*;


class Patient {
 int id;
 String name;
 int age;
 String disease;


 Patient(int id, String name, int age, String disease) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.disease = disease;
 }

 
 void display() {
     System.out.println("ID: " + id + ", Name: " + name +
             ", Age: " + age + ", Disease: " + disease);
 }
}

public class HospitalSystem {

 static HashMap<Integer, Patient> patientMap = new HashMap<>();

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     while (true) {
         System.out.println("\n--- Hospital Patient System ---");
         System.out.println("1. Add Patient");
         System.out.println("2. Update Patient");
         System.out.println("3. Retrieve Patient");
         System.out.println("4. Remove Patient");
         System.out.println("5. List All Patients");
         System.out.println("6. Check Patient Exists");
         System.out.println("7. Count Patients");
         System.out.println("8. Clear System");
         System.out.println("9. Exit");

         System.out.print("Enter choice: ");
         int choice = sc.nextInt();

         switch (choice) {

             case 1: 
                 System.out.print("Enter ID: ");
                 int id = sc.nextInt();

                 if (patientMap.containsKey(id)) {
                     System.out.println("Patient already exists!");
                     break;
                 }

                 sc.nextLine(); 
                 System.out.print("Enter Name: ");
                 String name = sc.nextLine();

                 System.out.print("Enter Age: ");
                 int age = sc.nextInt();

                 sc.nextLine();
                 System.out.print("Enter Disease: ");
                 String disease = sc.nextLine();

                 patientMap.put(id, new Patient(id, name, age, disease));
                 System.out.println("Patient added successfully!");
                 break;

             case 2: 
                 System.out.print("Enter ID to update: ");
                 int updateId = sc.nextInt();

                 if (!patientMap.containsKey(updateId)) {
                     System.out.println("Patient not found!");
                     break;
                 }

                 sc.nextLine();
                 System.out.print("Enter New Name: ");
                 String newName = sc.nextLine();

                 System.out.print("Enter New Age: ");
                 int newAge = sc.nextInt();

                 sc.nextLine();
                 System.out.print("Enter New Disease: ");
                 String newDisease = sc.nextLine();

                 patientMap.put(updateId,
                         new Patient(updateId, newName, newAge, newDisease));

                 System.out.println("Patient updated successfully!");
                 break;

             case 3: 
                 System.out.print("Enter ID: ");
                 int searchId = sc.nextInt();

                 if (patientMap.containsKey(searchId)) {
                     patientMap.get(searchId).display();
                 } else {
                     System.out.println("Patient not found!");
                 }
                 break;

             case 4: 
                 System.out.print("Enter ID to remove: ");
                 int removeId = sc.nextInt();

                 if (patientMap.remove(removeId) != null) {
                     System.out.println("Patient removed successfully!");
                 } else {
                     System.out.println("Patient not found!");
                 }
                 break;

             case 5: 
                 if (patientMap.isEmpty()) {
                     System.out.println("No patients available.");
                 } else {
                     for (Patient p : patientMap.values()) {
                         p.display();
                     }
                 }
                 break;

             case 6: 
                 System.out.print("Enter ID: ");
                 int checkId = sc.nextInt();

                 if (patientMap.containsKey(checkId)) {
                     System.out.println("Patient exists.");
                 } else {
                     System.out.println("Patient does not exist.");
                 }
                 break;

             case 7: 
                 System.out.println("Total Patients: " + patientMap.size());
                 break;

             case 8: 
                 patientMap.clear();
                 System.out.println("All patient records cleared!");
                 break;

             case 9:
                 System.out.println("Exiting...");
                 return;

             default:
                 System.out.println("Invalid choice!");
         }
     }
 }
}