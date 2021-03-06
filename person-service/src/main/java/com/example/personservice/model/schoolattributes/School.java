package com.example.personservice.model.schoolattributes;

import com.example.personservice.model.persons.Director;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "school")
    private Address address;

    @Column(name = "number")
    private int number;

    @OneToOne(mappedBy = "school")
    private Director director;

    public School() {

    }

    public School(Director director) {
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
