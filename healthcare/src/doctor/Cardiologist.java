package doctor;

import model.Patient;

public class Cardiologist extends Doctor {

    public Cardiologist(String name) {
        super(name, "Cardiology");
    }

    @Override
    public void diagnose(Patient patient) {
        System.out.println("\nDr. " + name + " (Cardiologist) is diagnosing " + patient.getName());

        if (patient.getIllness().toLowerCase().contains("heart")) {
            System.out.println("Diagnosis: Specialized heart treatment required.");
        } else {
            System.out.println("Diagnosis: Not a heart issue. Refer to General Physician.");
        }
    }
}