package com.jm.project.schooljournal.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.unbescape.properties.PropertiesKeyEscapeLevel;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(email = "uuid", unique = true)
    private int uuid;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

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

    public User(int uuid, Set<Role> role, String name, String soname, String patronymic, int age, String password) {
        this.uuid = uuid;
        this.role = role;
        this.name = name;
        this.soname = soname;
        this.patronymic = patronymic;
        this.age = age;
        this.password = password;
    }
}