package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Appointment;
import com.hello.FirstApp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/appointments")
@RestController
public class AppointmentControl {
    @Autowired
    private AppointmentService appoint_serve;

    @PostMapping
    public boolean postAppointment(@Valid @NotNull @RequestBody Appointment appointment){
        appoint_serve.createAppointment(appointment);
        return true;
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appoint_serve.readAllAppointments();
    }

    @GetMapping(path = "{id}")
    public Optional<Appointment> getAppointment(@PathVariable("id") int id){
        return appoint_serve.readAppointment(id);
    }

    @PutMapping(path = "{id}")
    public boolean putAppointment(@PathVariable("id") int id, @Valid @NotNull @RequestBody Appointment appointment){
        appointment.setCode(id);
        appoint_serve.updateAppointment(appointment);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteAppointment(@PathVariable("id") int id){
        appoint_serve.deleteAppointment(id);
        return true;
    }

    @GetMapping(path = "findByIssue/{issue}/{page}")
    public Page<Appointment> getAppointmentsByIssue(@PathVariable("issue") String issue, @PathVariable("page") Optional<Integer> page){
        return appoint_serve.findAppointmentsByIssue(issue, new PageRequest(page.orElse(0), 5));
    }

    @GetMapping(path = "findByDoctor/{doctor}/{page}") // Having a Issue with data type
    public Page<Appointment> getAppointmentsByDoctor(@PathVariable("doctor") Integer id, @PathVariable("page") Optional<Integer> page){
        return appoint_serve.findAppointmentsByDoctor(id, new PageRequest(page.orElse(0), 5));
    }

    @GetMapping(path = "order/{page}")
    public Page<Appointment> orderAppointment(@PathVariable("page") Optional<Integer> page){
        return appoint_serve.orderAppointments(new PageRequest(page.orElse(0), 5));
    }
}
