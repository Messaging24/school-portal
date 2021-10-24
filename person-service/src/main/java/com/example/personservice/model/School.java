package com.example.personservice.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class School {

    @Column(name = "director")
    @OneToOne(fetch = FetchType.EAGER)

    private Director director;

}
