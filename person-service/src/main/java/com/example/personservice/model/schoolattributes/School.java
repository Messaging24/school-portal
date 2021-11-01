package com.example.personservice.model.schoolattributes;

import com.example.personservice.model.Director;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "director")
    @OneToOne(fetch = FetchType.EAGER)
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
}
