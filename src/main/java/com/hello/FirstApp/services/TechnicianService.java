package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Technician;
import com.hello.FirstApp.repos.TechnicianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepo tech_repo;

    public boolean createTechnician(Technician tech){
        int num = (int)(Math.random()*1000000);
        tech.setAuth_code("SHTEC"+Integer.toString(num));
        tech_repo.save(tech);
        return true;
    }

    public List<Technician> readAllTechnicians(){
        return (List<Technician>) tech_repo.findAll();
    }

    public Optional<Technician> readTechnician(int id){
        return tech_repo.findById(id);
    }

    public boolean updateTechnician(Technician tech){
        createTechnician(tech);
        return true;
    }

    public boolean deleteTechnician(int id){
        tech_repo.deleteById(id);
        return true;
    }
}
