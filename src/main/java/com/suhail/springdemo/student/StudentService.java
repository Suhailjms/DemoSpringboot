package com.suhail.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
public interface StudentService {
    Student save(Student s);
    Student findByEmail(String email);
    Student update(Student s);
    void delete(String email);
     List<Student> findAllStudents(); // always recomended to use interface and implement them List is the interface

    }
