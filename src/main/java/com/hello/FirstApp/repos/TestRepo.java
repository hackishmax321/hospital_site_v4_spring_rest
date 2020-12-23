package com.hello.FirstApp.repos;

import com.hello.FirstApp.modals.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<Test, Integer> {


    @Query(value = "Select e From Test e where e.id_patient = ?1 order by e.issue_date")
    public Page<Test> findByPatient(int id, Pageable pageable);
}
