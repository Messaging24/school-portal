package com.example.personservice.model.persons;

import com.example.personservice.model.schoolattributes.Form;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //присоединяем к классу
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    //@PrimaryKeyJoinColumn //Первичный ключ student используется в Form
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    @JsonIgnoreProperties("studentsList")
    public Form form;

    // присоединяем к родителю
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}, //Исключил remove, что бы не удалять связанные сущности
            fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "parentId")
    @JsonIgnoreProperties("studentsList")
    private Parent parent;

    public Student() {
    }

    public Student(String firstName, String secondName, String lastName, char gender, int age, Form form, Parent parent) {
        super(firstName, secondName, lastName, gender, age);
        this.form = form;
        this.parent = parent; //Добавил на задаче 3064 + сеттер и геттер
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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
