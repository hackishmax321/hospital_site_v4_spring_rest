package com.hello.FirstApp.services;

import com.hello.FirstApp.modals.Test;
import com.hello.FirstApp.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepo test_repo;

    public boolean createTest(Test test){
        test_repo.save(test);
        return true;
    }

    public List<Test> readAllTests(){
        return (List<Test>) test_repo.findAll();
    }

    public Optional<Test> readTest(int id){
        return test_repo.findById(id);
    }

    public boolean updateTest(Test test){
        createTest(test);
        return true;
    }

    public boolean deleteTest(int id){
        test_repo.deleteById(id);
        return true;
    }

    public Page<Test> findTestsByPatient(int id, Pageable pageable){
        return test_repo.findByPatient(id, pageable);
    }

}
