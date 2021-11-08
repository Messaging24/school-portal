package com.example.personservice.model.persons;

//TODO унаследовать от Person
//  Добавить связку родитель ученик (OneToMany)

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent")
public class Parent extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentId;

    @OneToMany(targetEntity = Student.class,
            mappedBy = "parent",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST}, //Исключил remove, что бы не удалять связанные сущности
            orphanRemoval = true)
    @JsonIgnoreProperties("parent")
    private List<Student> studentsList;

    public Parent() {
    }

    public Parent(String firstName, String lastName, String secondName, char gender, int age, List studentsList) {
        super(firstName, lastName, secondName, gender, age);
        this.studentsList = studentsList;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long id) {
        this.parentId = id;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

}
