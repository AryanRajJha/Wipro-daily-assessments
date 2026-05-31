package healthcare;
import java.util.*;

class Patient {
 private int id;
 private String name;
 private int age;
 private String illness;

 public Patient(int id, String name, int age, String illness) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.illness = illness;
 }

 public int getId() { return id; }
 public String getName() { return name; }
 public int getAge() { return age; }
 public String getIllness() { return illness; }
}

interface PatientService {
 void registerPatient(Patient patient);
 void showPatient(int id);
}

class PatientServiceImpl implements PatientService {
 private Map<Integer, Patient> patientMap = new HashMap<>();

 public void registerPatient(Patient patient) {
     patientMap.put(patient.getId(), patient);
     System.out.println("Patient Registered Successfully!");
 }

 public void showPatient(int id) {
     Patient p = patientMap.get(id);
     if (p != null) {
         System.out.println("\n--- Patient Details ---");
         System.out.println("ID: " + p.getId());
         System.out.println("Name: " + p.getName());
         System.out.println("Age: " + p.getAge());
         System.out.println("Illness: " + p.getIllness());
     } else {
         System.out.println("Patient not found!");
     }
 }

 public Patient getPatient(int id) {
     return patientMap.get(id);
 }
}

abstract class Doctor {
 protected String name;
 protected String specialization;

 public Doctor(String name, String specialization) {
     this.name = name;
     this.specialization = specialization;
 }

 abstract void diagnose(Patient patient);
}

class GeneralPhysician extends Doctor {
 public GeneralPhysician(String name) {
     super(name, "General");
 }

 void diagnose(Patient patient) {
     System.out.println("Dr. " + name + " diagnosed " + patient.getName() +
             " with " + patient.getIllness());
 }
}

class Cardiologist extends Doctor {
 public Cardiologist(String name) {
     super(name, "Cardiology");
 }

 void diagnose(Patient patient) {
     if (patient.getIllness().toLowerCase().contains("heart")) {
         System.out.println("Dr. " + name + " treated heart issue of " + patient.getName());
     } else {
         System.out.println("Dr. " + name + " suggests general checkup for " + patient.getName());
     }
 }
}

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     PatientServiceImpl service = new PatientServiceImpl();

     while (true) {
         System.out.println("\n--- Healthcare System ---");
         System.out.println("1. Register Patient");
         System.out.println("2. Show Patient Details");
         System.out.println("3. Diagnose Patient");
         System.out.println("4. Exit");
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
                 sc.nextLine();

                 System.out.print("Enter Illness: ");
                 String illness = sc.nextLine();

                 Patient p = new Patient(id, name, age, illness);
                 service.registerPatient(p);
                 break;

             case 2:
                 System.out.print("Enter Patient ID: ");
                 int searchId = sc.nextInt();
                 service.showPatient(searchId);
                 break;

             case 3:
                 System.out.print("Enter Patient ID: ");
                 int pid = sc.nextInt();
                 sc.nextLine();

                 Patient patient = service.getPatient(pid);
                 if (patient == null) {
                     System.out.println("Patient not found!");
                     break;
                 }

                 System.out.println("Choose Doctor:");
                 System.out.println("1. General Physician");
                 System.out.println("2. Cardiologist");
                 int docChoice = sc.nextInt();

                 Doctor doctor;
                 if (docChoice == 1) {
                     doctor = new GeneralPhysician("Falana");
                 } else {
                     doctor = new Cardiologist("Dhimkana");
                 }

                 doctor.diagnose(patient);
                 break;

             case 4:
                 System.out.println("Exiting...");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice!");
         }
     }
 }
}