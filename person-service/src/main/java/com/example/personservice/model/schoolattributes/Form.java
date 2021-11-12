package com.example.personservice.model.schoolattributes;

import com.example.personservice.enums.Items;
import com.example.personservice.model.persons.Student;
import com.example.personservice.model.persons.Teacher;
import com.example.personservice.enums.Profile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forms")
public class Form {

    private final int max_capacity = 1320;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "name")
    private String name;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "profile")
    //@Enumerated(EnumType.STRING)
    private Profile profile;

    @Column(name = "items_list")
    //@Enumerated
    @ElementCollection(targetClass = Items.class)
    private List<Items> itemsList;

    @Column(name = "students_list")
    @OneToMany(targetEntity = Student.class,
            mappedBy = "form",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Student> studentsList;

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Form() {
    }

    public Form(Long id, int number, String name, String formName, Profile profile, List<Items> itemsList, List<Student> studentsList, Teacher teacher) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.formName = formName;
        this.profile = profile;
        this.itemsList = itemsList;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return formName;
    }
}
