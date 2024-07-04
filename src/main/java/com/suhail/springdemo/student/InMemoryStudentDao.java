package com.suhail.springdemo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository //data fetching like that
public class InMemoryStudentDao {
     private final List<Student> STUDENTS = new ArrayList<>();

    public Student save(Student s) {
         STUDENTS.add(s);
        return s;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(s->email.equals(s.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public Student update(Student s) {
        var studentIndex = IntStream.range(0,STUDENTS.size())
                .filter(index -> STUDENTS.get(index)
                        .getEmail().equals(s.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex>-1){
            STUDENTS.set(studentIndex,s); // it take a index and update the given student details
            return s;
        }
        return null;
    }

    public void delete(String email) {
        var student = findByEmail(email);
        if(student!=null){
            STUDENTS.remove(student);
        }
    }

    public List<Student> findAllStudents() {
        return STUDENTS;
    }
}

//shortcuts alt+j to select the same words
