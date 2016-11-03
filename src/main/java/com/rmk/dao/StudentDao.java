package com.rmk.dao;

import com.rmk.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */


public interface StudentDao {

    public List<Student> getAll();

    public void save(Student student);

}
