package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Integer> {
}
