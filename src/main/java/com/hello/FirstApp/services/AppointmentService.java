package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Appointment;
import com.hello.FirstApp.repos.AppointmentRepo;
import com.hello.FirstApp.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointment_repo;

    public boolean createAppointment(Appointment appointment){
        appointment_repo.save(appointment);
        return true;
    }

    public List<Appointment> readAllAppointments(){
        return (List<Appointment>) appointment_repo.findAll();
    }

    public Optional<Appointment> readAppointment(int id){
        return appointment_repo.findById(id);
    }

    public boolean updateAppointment(Appointment appointment){
        createAppointment(appointment);
        return true;
    }

    public boolean deleteAppointment(int id){
        appointment_repo.deleteById(id);
        return true;
    }

    public Page<Appointment> getAppointmentsPages(Pageable pageable){
        return appointment_repo.getAllAppointmentsForPages(pageable);
    }

    public Page<Appointment> findAppointmentsByIssue(String issue, Pageable pageable){
        return appointment_repo.findByIssue(issue, pageable);
    }

    public Page<Appointment> findAppointmentsByDoctor(Integer id, Pageable pageable){
        return appointment_repo.findByDoctor(id, pageable);
    }

    public Page<Appointment> orderAppointments(Pageable pageable){
        return appointment_repo.orderAppointmentsByDate(pageable);
    }
}
