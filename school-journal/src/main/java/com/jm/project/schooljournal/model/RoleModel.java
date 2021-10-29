package com.jm.project.schooljournal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users_role")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private ERole name;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

    public RoleModel(ERole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

//    public RoleModel(Set<User> users) {
//        this.users = users;
//    }
//
//    public RoleModel(String role, Set<User> users) {
//        this.role = role;
//        this.users = users;
//    }

    public RoleModel() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RoleModel roleModel = (RoleModel) o;
//        //TODO
//        return id == roleModel.id && Objects.equals(role, roleModel.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, role);
//    }
//
//    @Override
//    public String toString() {
//        return "Role: " + this.id + " " + this.role;
//    }
//
//    @Override
//    public String getAuthority() {
//        return getRole();
//    }

}

