package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Technician;
import com.hello.FirstApp.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/technicians")
@RestController
public class TechnicianControl {

    @Autowired
    private TechnicianService tech_serve;

    @PostMapping
    public boolean postTechnician(@Valid @NotNull @RequestBody Technician tech){
        tech_serve.createTechnician(tech);
        return true;
    }

    @GetMapping
    public List<Technician> getAllTechnicians(){
        return tech_serve.readAllTechnicians();
    }

    @GetMapping(path = "{id}")
    public Optional<Technician> getTechnician(@PathVariable("id") int id){
        return tech_serve.readTechnician(id);
    }

    @PutMapping(path = "{id}")
    public boolean putTechnician(@PathVariable("id") int id, @Valid @NotNull @RequestBody Technician technician){
        technician.setID(id);
        tech_serve.updateTechnician(technician);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteTechnician(@PathVariable("id") int id){
        tech_serve.deleteTechnician(id);
        return true;
    }
}
