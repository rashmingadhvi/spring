package com.rmk.service;

import com.rmk.dao.StudentDao;
import com.rmk.dao.StudentDaoImpl;
import com.rmk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@Transactional
@Service("studentservice")
public class StudentServiceImpl implements StudentService {
    @Autowired @Qualifier ("studentdao")
    StudentDao dao;

    public List<Student> serviceCall() {
        return dao.getAll();
    }

    public void saveStudent(Student student) {
        dao.save(student);
    }
}
