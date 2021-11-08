package com.example.personservice.model.schoolattributes;

import com.example.personservice.model.persons.Student;
import com.example.personservice.model.persons.Teacher;
import com.example.personservice.profile.Profile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private int number; //1-11

    @Column(name = "name")
    private String name; //А, Б, В, Г, Д

    @Column(name = "form_name")
    private String formName; //number + name: 1А, 2Б....

    @Column(name = "profile")
    private Profile profile;

    @Column(name = "items_list")
    private List<Items> itemsList;

    @Column(name = "students_list")
    private List<Student> studentsList;

    @Column(name = "teacher")
    private Teacher teacher;

    @Column(name = "school")
    private School school;

    public Form() {
    }

    public Form(Long id, int number, String name, String formName, Profile profile, List<Items> itemsList, List<Student> studentsList, Teacher teacher, School school) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.formName = formName;
        this.profile = profile;
        this.itemsList = itemsList;
        this.studentsList = studentsList;
        this.teacher = teacher;
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return formName;
    }
}
