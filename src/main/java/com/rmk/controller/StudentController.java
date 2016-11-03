package com.rmk.controller;

import com.rmk.model.Student;
import com.rmk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@RestController(value = "studentcontroller")
public class StudentController {

    @Autowired @Qualifier("studentservice")
    StudentService service;


    public String test(){
        return "Hello RMK!";
    }

    public List<Student> getAllStudents(){
        return service.serviceCall();
    }
}
