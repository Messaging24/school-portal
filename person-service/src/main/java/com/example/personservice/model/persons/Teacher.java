package com.example.personservice.model.persons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

//    @OneToMany(mappedBy = "id",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<Classes> classesList;

    public Teacher() {

    }

    public Teacher(String firstName, String lastName, String secondName, char gender, int age, Long id
//            ,List<Classes> classesList
    ) {
        super(firstName, lastName, secondName, gender, age);
        this.id = id;
//        this.classesList = classesList;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

}
