package com.jm.project.schooljournal.service;

import com.jm.project.schooljournal.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    User loadUserByUsername(String username) throws UsernameNotFoundException;

}
