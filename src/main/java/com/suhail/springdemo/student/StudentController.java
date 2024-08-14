package com.suhail.springdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService service; //tightly coupled becoz relay on the instance of stu service our spring continer not manageing the life cycle becox of new keyword
//    @Autowired //to inject service in the controller // if we use contructor we can eliminate the use of autowired
    public StudentController(
            @Qualifier("db") StudentService service) {
           // this qualifier specify the service that needs to be injected in the controller
        this.service = service;
    }

    @PostMapping("/add")
    public Student save(@RequestBody Student student){
         return service.save(student);
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email){ // variable inside the pathvarible should be same as in path
        return service.findByEmail(email);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return service.update(student);
    }
    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        service.delete(email);
    }
    @GetMapping
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }
}
