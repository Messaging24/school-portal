package com.example.personservice.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Form school_class;

    public Student() {
    }

    public Student(String firstName, String secondName, String lastName, char gender, int age) {
        super(firstName, secondName, lastName, gender, age);
    }

    public Form getSchool_class() {
        return school_class;
    }

    public void setSchool_class(Form school_class) {
        this.school_class = school_class;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getSecondName() {
        return super.getSecondName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public char getGender() {
        return super.getGender();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void setGender(char gender) {
        super.setGender(gender);
    }
}
