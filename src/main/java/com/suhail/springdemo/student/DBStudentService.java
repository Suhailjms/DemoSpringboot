package com.suhail.springdemo.student;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


//to inject service function
//@Primary // if one or more service is present then this service will be injects in the controller if the primary annotation is mentioned
@Service
public class DBStudentService implements StudentService {

    private final StudentRepository repository;

    public DBStudentService(StudentRepository repository) {
// adding constructor to automatic inject
        this.repository = repository;
    }

    @Override
    public Student save(Student s) {
        return repository.save(s);
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student update(Student s) {
        return repository.save(s);
    }

    @Transactional
    @Override
    public void delete(String email) {
        repository.deleteByEmail(email);
    }
}