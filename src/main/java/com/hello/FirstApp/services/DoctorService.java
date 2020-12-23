package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Doctor;
import com.hello.FirstApp.repos.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctor_repo;

    public boolean createDoctor(Doctor doctor){
        int num = (int)(Math.random()*1000000);
        doctor.setAuth_code("SHDOC"+Integer.toString(num));
        doctor_repo.save(doctor);
        return true;
    }

    public List<Doctor> readAllDoctors(){
        return (List<Doctor>) doctor_repo.findAll();
    }

    public Optional<Doctor> readDoctor(int id){
        return doctor_repo.findById(id);
    }

    public boolean updateDoctor(Doctor doctor){
        createDoctor(doctor);
        return true;
    }

    public boolean deleteDoctor(int id){
        doctor_repo.deleteById(id);
        return true;
    }
}
