package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Patient;
import com.hello.FirstApp.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patient_repo;

    public boolean createPatient(Patient patient){
        int num = (int)(Math.random()*1000000);
        patient.setAuth_code("SHPAT"+Integer.toString(num));
        patient_repo.save(patient);
        return true;
    }

    public List<Patient> readAllPatients(){
        return (List<Patient>) patient_repo.findAll();
    }

    public Optional<Patient> readPatient(int id){
        return patient_repo.findById(id);
    }

    public boolean updatePatient(Patient patient){
        createPatient(patient);
        return true;
    }

    public boolean deletePatient(int id){
        patient_repo.deleteById(id);
        return true;
    }
}
