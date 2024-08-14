package com.suhail.springdemo.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {  // it takes 2 parameters class and id
    Student findByEmail(String email);
    void deleteByEmail(String email);
}
