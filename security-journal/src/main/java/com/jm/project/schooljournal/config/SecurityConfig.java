package com.jm.project.schooljournal.config;

import com.jm.project.schooljournal.model.User;
import com.jm.project.schooljournal.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            User user = userRepository.findUserByUsername(username);
            if (user != null) {
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                );
            }
            throw new UsernameNotFoundException("User '" + username + "' not exists");
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO configure web security
        http
                .cors()
                .and()
                .csrf().disable()
//                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                .addFilter(new AuthenticationFilter(authenticationManager()))
//                    .addFilter(new AuthorizationFilter(authenticationManagerBean(), userRepository))
                .authorizeRequests()
                .antMatchers("/auth/signin", "/auth/refresh", "/api/public/**").permitAll()
                .antMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
