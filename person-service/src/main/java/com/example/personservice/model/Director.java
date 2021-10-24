package com.example.personservice.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private int startManagement;

    @Column
    private int endManagement;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "director_school", joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "school_id"))
    private School school;

    public Director() {
    }

    public Director(School school, String firstName, String lastName, String secondName, char gender, int age) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setSecondName(secondName);
        super.setGender(gender);
        super.setAge(age);
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getStartManagement() {
        return startManagement;
    }

    public void setStartManagement(int startManagement) {
        this.startManagement = startManagement;
    }

    public int getEndManagement() {
        return endManagement;
    }

    public void setEndManagement(int endManagement) {
        this.endManagement = endManagement;
    }


}
