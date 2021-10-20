package com.jm.project.schooljournal.model;

import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(email = "uuid", unique = true)
    private String uuid;

    @Column(name = "userName")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "soname")
    private String soname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    public User(String userName, String password, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}


