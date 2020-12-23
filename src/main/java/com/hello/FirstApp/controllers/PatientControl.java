package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Patient;
import com.hello.FirstApp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/patients")
@RestController
public class PatientControl {

    @Autowired
    private PatientService patient_serve;

    @PostMapping
    public boolean postPatient(@Valid @NotNull @RequestBody Patient patient){
        patient_serve.createPatient(patient);
        return true;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patient_serve.readAllPatients();
    }

    @GetMapping(path = "{id}")
    public Optional<Patient> getPatient(@PathVariable("id") int id){
        return patient_serve.readPatient(id);
    }

    @PutMapping(path = "{id}")
    public boolean putPatient(@PathVariable("id") int id, @Valid @NotNull @RequestBody Patient patient){
        patient.setID(id);
        patient_serve.updatePatient(patient);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deletePatient(@PathVariable("id") int id){
        patient_serve.deletePatient(id);
        return true;
    }
}
