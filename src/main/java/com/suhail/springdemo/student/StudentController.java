package com.suhail.springdemo.student;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    //tightly coupled becoz relay on the instance of stu service our spring continer not manageing the life cycle becox of new keyword
//    @Autowired //to inject service in the controller // if we use contructor we can eliminate the use of autowired
    public StudentController(
            @Qualifier("DBStudentService") StudentService service  // this qualifier specify the service that needs to be injected in the controller
    ) {
        this.service = service;
    }

    @PostMapping
    public Student save(
            @RequestBody Student student
    ) {
        return service.save(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(
            @PathVariable("email") String email
    ) {
        return service.findByEmail(email);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @PutMapping
    public Student updateStudent(
            @RequestBody Student student
    ) {
        return service.update(student);
    }

    @DeleteMapping("/{email}")
    public String delete(
            @PathVariable("email") String email
    ) {
        service.delete(email);
        return "deleted";
    }

}
