package com.example.personservice.model.persons;

import com.example.personservice.model.schoolattributes.Form;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "teacher",
    cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST},
    //cascade - При удалении учителя не удалять связанный объект класса
    fetch = FetchType.LAZY)
    private Form form;

    public Teacher() {

    }

    public Teacher(String firstName, String lastName, String secondName, char gender, int age, Long id, Form form) {
        super(firstName, lastName, secondName, gender, age);
        this.id = id;
        this.form = form;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
