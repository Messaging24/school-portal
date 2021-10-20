package com.jm.project.schooljournal.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(email = "uuid", unique = true)
    private int uuid;

    @Column(role = "role")
    private int role;

    @Column(name = "name")
    private String name;

    @Column(name = "soname")
    private String soname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private String password;

    public User(int uuid, String role, String name, String soname, String patronymic, int age, String password) {
        this.uuid = uuid;
        this.role = role;
        this.name = name;
        this.soname = soname;
        this.patronymic = patronymic;
        this.age = age;
        this.password = password;
    }
}