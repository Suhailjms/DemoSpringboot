package com.suhail.springdemo.student;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("db") //to inject service function
//@Primary // if one or more service is present then this service will be injects in the controller if the primary annotation is mentioned
public class DBStudentService implements StudentService{

    private final StudentRepository repository;

    public DBStudentService(StudentRepository repository) {  // adding constructor to automatic inject
        this.repository = repository;
    }

    @Override
    public Student save(Student s) {
        return repository.save(s);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student update(Student s) {
        return repository.save(s);
    }

    @Override
    public void delete(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }
}
