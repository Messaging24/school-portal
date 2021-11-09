package com.example.personservice.model.persons;

import com.example.personservice.model.schoolattributes.School;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Director extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Date startManagement;

    @Column
    private Date endManagement;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "director_school", joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "school_id"))
    private School school;

    public Director() {
    }

    public Director(School school, String firstName, String lastName, String secondName, char gender, int age) {
        super(firstName, lastName, secondName, gender, age);
        this.school = school;

    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Date getStartManagement() {
        return startManagement;
    }

    public void setStartManagement(Date startManagement) {
        this.startManagement = startManagement;
    }

    public Date getEndManagement() {
        return endManagement;
    }

    public void setEndManagement(Date endManagement) {
        this.endManagement = endManagement;
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
