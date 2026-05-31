package service;

import model.Patient;

public interface PatientService {
    void registerPatient(Patient patient);
    void showPatient(int id);
    Patient getPatient(int id);
}