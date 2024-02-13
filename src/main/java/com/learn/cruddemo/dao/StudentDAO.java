package com.learn.cruddemo.dao;

import com.learn.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String lastname);

    void updateFirstName(Student theStudent);

    void deleteStudent(Integer id);

    int deleteAll();
}
