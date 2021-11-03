package com.jm.project.schooljournal.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "uuid", unique = true)
    private UUID uuid;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RoleModel> roles;

    public User(String userName, String password, Set<RoleModel> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public User() {}

    public String getUserName() { return userName; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return userName; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}