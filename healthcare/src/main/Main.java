package main;

import java.util.Scanner;

import model.Patient;
import service.*;
import doctor.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientServiceImpl();

        Doctor generalDoctor = new GeneralPhysician("Sharma");
        Doctor cardioDoctor = new Cardiologist("Mehta");

        int choice;

        do {
            System.out.println("\n===== Healthcare Management System =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Show Patient Details");
            System.out.println("3. Diagnose (General Physician)");
            System.out.println("4. Diagnose (Cardiologist)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

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
                    int pid = sc.nextInt();
                    service.showPatient(pid);
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    int gpId = sc.nextInt();
                    Patient gp = service.getPatient(gpId);

                    if (gp != null)
                        generalDoctor.diagnose(gp);
                    else
                        System.out.println("Patient not found!");
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    int cId = sc.nextInt();
                    Patient cp = service.getPatient(cId);

                    if (cp != null)
                        cardioDoctor.diagnose(cp);
                    else
                        System.out.println("Patient not found!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}