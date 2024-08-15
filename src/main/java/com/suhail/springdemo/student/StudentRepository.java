package com.suhail.springdemo.student;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {  // it takes 2 parameters class and id
    Student findByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.email = ?1")
    void deleteByEmail(String email);
}
