package com.rmk.dao;

import com.rmk.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@Repository("studentdao")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
    }

    public void save(Student student){
        sessionFactory.getCurrentSession().persist(student);
    }
}
