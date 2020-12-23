package com.hello.FirstApp.controllers;

import com.hello.FirstApp.modals.Test;
import com.hello.FirstApp.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/tests")
@RestController
public class TestControl {
    @Autowired
    private TestService test_serve;

    @PostMapping
    public boolean postTest(@Valid @NotNull @RequestBody Test doctor){
        test_serve.createTest(doctor);
        return true;
    }

    @GetMapping
    public List<Test> getAllTests(){
        return test_serve.readAllTests();
    }

    @GetMapping(path = "{id}")
    public Optional<Test> getTest(@PathVariable("id") int id){
        return test_serve.readTest(id);
    }

    @PutMapping(path = "{id}")
    public boolean putTest(@PathVariable("id") int id, @Valid @NotNull @RequestBody Test test){
        test.setCode(id);
        test_serve.updateTest(test);
        return true;
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteTest(@PathVariable("id") int id){
        test_serve.deleteTest(id);
        return true;
    }

    @GetMapping(path = "find/{id}/{page}")
    public Page<Test> getTestsByPatient(@PathVariable("id") int id, @PathVariable("id") Optional<Integer> page){
        return test_serve.findTestsByPatient(id, new PageRequest(page.orElse(0), 5));
    }
}
