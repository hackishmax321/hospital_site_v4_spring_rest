package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, Integer> {
}
