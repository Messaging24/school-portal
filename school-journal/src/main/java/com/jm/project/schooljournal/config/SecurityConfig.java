package com.jm.project.schooljournal.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO configure authentication manager

    }

// TODO: Установите управление сеансом.
// TODO: Установить обработчик исключений неавторизованных запросов.
// TODO: Установите разрешения для конечных точек.
// TODO: Добавить фильтр токенов JWT.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO configure web security
        http
                // TODO: 18.10.2021 Включите CORS и отключите CSRF
                .csrf().disable()
                .cors()
                .and()

                // TODO: Установите управление сеансом.
                .authorizeRequests()
                .antMatchers("/user/**").access("hasAnyRole('HEADTECHER','TEACHER','PARENT','STUDENT','DIRECTOR')")

                .antMatchers("/**").access("hasAnyRole('DIRECTOR')")

                .and()
                // TODO: Установить обработчик исключений неавторизованных запросов.
                // TODO to build classes SimpleAccessDeniedHandler and SimpleAuthenticationEntryPoint
//                .exceptionHandling().accessDeniedHandler(new SimpleAccessDeniedHandler()).authenticationEntryPoint(new SimpleAuthenticationEntryPoint())

                .formLogin()  // Spring сам подставит свою логин форму
//                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/user", true)

                .failureUrl("/login?error=true")
                .usernameParameter("email")
//                .passwordParameter("password")
                // TODO
                // .successHandler()// подключаем наш SuccessHandler для перенеправления по ролям
                .permitAll()
// TODO  Добавить фильтр токенов JWT.
//            .and()
//            .oauth2ResourceServer().jwt() далее конфигурация

                .and()
                .logout()
                .logoutUrl("/logout") //URL-адрес, запускающий выход из системы (по умолчанию "/ logout").
                .logoutSuccessUrl("/");//URL-адрес для перенаправления после выхода из системы
    }


//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(ImmutableList.of("*"));
//        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
//        final source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }UrlBasedCorsConfigurationSource

}
