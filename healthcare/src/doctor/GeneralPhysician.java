package doctor;

import model.Patient;

public class GeneralPhysician extends Doctor {

    public GeneralPhysician(String name) {
        super(name, "General Medicine");
    }

    @Override
    public void diagnose(Patient patient) {
        System.out.println("\nDr. " + name + " (General Physician) is diagnosing " + patient.getName());
        System.out.println("Diagnosis: Basic treatment for " + patient.getIllness());
    }
}