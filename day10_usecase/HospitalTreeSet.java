package day10_usecase;

import java.util.*;


class PatientS implements Comparable<PatientS> {
 int id;
 String name;
 int age;
 String disease;


 PatientS(int id, String name, int age, String disease) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.disease = disease;
 }


 public int compareTo(PatientS p) {
     return this.id - p.id;
 }

 void display() {
     System.out.println("ID: " + id + ", Name: " + name +
             ", Age: " + age + ", Disease: " + disease);
 }
}

public class HospitalTreeSet {

 static TreeSet<PatientS> patients = new TreeSet<>();


 static PatientS findPatient(int id) {
     for (PatientS p : patients) {
         if (p.id == id) {
             return p;
         }
     }
     return null;
 }

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     while (true) {
         System.out.println("\n--- Hospital Patient System (TreeSet) ---");
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

                 if (findPatient(id) != null) {
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

                 patients.add(new PatientS(id, name, age, disease));
                 System.out.println("Patient added successfully!");
                 break;

             case 2: 
                 System.out.print("Enter ID to update: ");
                 int updateId = sc.nextInt();

                 PatientS existing = findPatient(updateId);

                 if (existing == null) {
                     System.out.println("Patient not found!");
                     break;
                 }

                 patients.remove(existing); // remove old

                 sc.nextLine();
                 System.out.print("Enter New Name: ");
                 String newName = sc.nextLine();

                 System.out.print("Enter New Age: ");
                 int newAge = sc.nextInt();

                 sc.nextLine();
                 System.out.print("Enter New Disease: ");
                 String newDisease = sc.nextLine();

                 patients.add(new PatientS(updateId, newName, newAge, newDisease));
                 System.out.println("Patient updated successfully!");
                 break;

             case 3: 
                 System.out.print("Enter ID: ");
                 int searchId = sc.nextInt();

                 PatientS p = findPatient(searchId);
                 if (p != null) {
                     p.display();
                 } else {
                     System.out.println("Patient not found!");
                 }
                 break;

             case 4: 
                 System.out.print("Enter ID to remove: ");
                 int removeId = sc.nextInt();

                 PatientS toRemove = findPatient(removeId);
                 if (toRemove != null) {
                     patients.remove(toRemove);
                     System.out.println("Patient removed successfully!");
                 } else {
                     System.out.println("Patient not found!");
                 }
                 break;

             case 5: 
                 if (patients.isEmpty()) {
                     System.out.println("No patients available.");
                 } else {
                     for (PatientS pt : patients) {
                         pt.display();
                     }
                 }
                 break;

             case 6: 
                 System.out.print("Enter ID: ");
                 int checkId = sc.nextInt();

                 if (findPatient(checkId) != null) {
                     System.out.println("Patient exists.");
                 } else {
                     System.out.println("Patient does not exist.");
                 }
                 break;

             case 7: 
                 System.out.println("Total Patients: " + patients.size());
                 break;

             case 8: 
                 patients.clear();
                 System.out.println("All records cleared!");
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