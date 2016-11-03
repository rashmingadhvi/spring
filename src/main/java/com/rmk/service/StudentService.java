package com.rmk.service;

import com.rmk.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */

public interface StudentService {

    public List<Student> serviceCall();

    public void saveStudent(Student student);
}
