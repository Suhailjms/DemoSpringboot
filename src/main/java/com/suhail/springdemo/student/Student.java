package com.suhail.springdemo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dob;

    @Column(unique = true)
    private String email;

    @Transient   // is to prevent adding the field in the table
    private int age;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public Student(String firstname, String lastname, LocalDate dob, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
    }

    public int getAge() {

        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
