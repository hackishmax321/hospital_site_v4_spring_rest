package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Technician;
import org.springframework.data.repository.CrudRepository;

public interface TechnicianRepo extends CrudRepository<Technician, Integer> {

}
