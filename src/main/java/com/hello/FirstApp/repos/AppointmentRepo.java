package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {

    //    Get All - For More supesticated uses
    @Query("Select e From Appointment e")
    public Page<Appointment> getAllAppointmentsForPages(Pageable pageable);

    //    Get Appointment by issue
    public Page<Appointment> findByIssue(String issue, Pageable pageable);


    //    Get Appointments by Doctor
//    @Query(value = "From Appointment appoint where appoint.fk_doctor = ?1")
//    public Page<Appointment> findByDoctor(int id, Pageable pageable);

    @Query("Select e From Appointment e where e.id_doctor = ?1")
    public Page<Appointment> findByDoctor(Integer id, Pageable pageable);

//    @Query(value = "From Appointment appoint where appoint.fk_patient = ?1")
//    public Page<Appointment> findByPatient(int id, Pageable pageable);

//    Get Appointments in order
    @Query(value = "From Appointment appoint order by appoint.due_date desc")
    public Page<Appointment> orderAppointmentsByDate(Pageable pageable);


}
