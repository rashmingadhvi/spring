package com.rmk.model;

import javax.persistence.*;

/**
 * Created by RashMin on 29-10-2016.
 */
@Entity
@Table(name = "student")
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int studentId;
    String fName;
    String lName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
