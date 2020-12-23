package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Doctor;
import com.hello.FirstApp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/doctors")
@RestController
public class DoctorControl {
    @Autowired
    private DoctorService doctor_serve;

    @PostMapping
    public boolean postDoctor(@Valid @NotNull @RequestBody Doctor doctor){
        doctor_serve.createDoctor(doctor);
        return true;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctor_serve.readAllDoctors();
    }

    @GetMapping(path = "{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        return doctor_serve.readDoctor(id);
    }

    @PutMapping(path = "{id}")
    public boolean putDoctor(@PathVariable("id") int id, @Valid @NotNull @RequestBody Doctor doctor){
        doctor.setID(id);
        doctor_serve.updateDoctor(doctor);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteDoctor(@PathVariable("id") int id){
        doctor_serve.deleteDoctor(id);
        return true;
    }
}
