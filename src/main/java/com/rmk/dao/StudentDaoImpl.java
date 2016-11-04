package com.rmk.dao;

import com.rmk.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@Repository("studentdao")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getAll() {
        System.out.println("###########getALL################");
        System.out.println(this.sessionFactory);
        return this.sessionFactory.getCurrentSession().createCriteria(Student.class).list();
    }

    public void save(Student student){
        this.sessionFactory.getCurrentSession().persist(student);
    }
}
