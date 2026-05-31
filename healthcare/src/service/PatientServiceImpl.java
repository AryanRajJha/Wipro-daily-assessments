package service;

import model.Patient;
import java.util.HashMap;
import java.util.Map;

public class PatientServiceImpl implements PatientService {

    private Map<Integer, Patient> patientMap = new HashMap<>();

    @Override
    public void registerPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
        System.out.println("Patient registered successfully: " + patient.getName());
    }

    @Override
    public void showPatient(int id) {
        Patient p = patientMap.get(id);
        if (p != null) {
            System.out.println("\nPatient Details:");
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
            System.out.println("Illness: " + p.getIllness());
        } else {
            System.out.println("Patient not found!");
        }
    }

    @Override
    public Patient getPatient(int id) {
        return patientMap.get(id);
    }
}