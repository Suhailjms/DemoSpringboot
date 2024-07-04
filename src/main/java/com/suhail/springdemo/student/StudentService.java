package com.suhail.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student(
                        "Suhail",
                        "jms",
                        LocalDate.now(),
                        "suhail@gmail.com",
                        20

                ),
                new Student(
                        "Mohammed J",
                        "jms",
                        LocalDate.now(),
                        "suhail7@gmail.com",
                        21

                )
        );
    }
}
