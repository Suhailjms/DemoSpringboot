package com.suhail.springdemo.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("in")//the values as bean. spring will create bean for inme..service and it will call at "im"
// to tell the spring that this is bean
public class InMemoryStudentService implements StudentService {

    private final InMemoryStudentDao dao;

    public InMemoryStudentService(InMemoryStudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student save(Student s) {
        return dao.save(s);
    }

    @Override
    public Student findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public Student update(Student s) {
        return dao.update(s);
    }

    @Override
    public void delete(String email) {
        dao.delete(email);
    }

    @Override
    public List<Student> findAllStudents() {
        return dao.findAllStudents();
    }
}
