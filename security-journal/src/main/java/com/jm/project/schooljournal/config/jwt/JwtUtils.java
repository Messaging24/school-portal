package com.jm.project.schooljournal.config.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    // TODO значения вынести в проперти
    @Value("MegaLargeSigningSecretKeyForDemoApplicationMegaLargeSigningSecretKeyForDemoApplication")
    private String jwtSecret;
    @Value("86400000")
    private int jwtExpirationMs;

//# App Properties
//app.jwtSecret=MegaLargeSigningSecretKeyForDemoApplicationMegaLargeSigningSecretKeyForDemoApplication
//app.jwtExpirationMs=86400000


    // СОЗДАНИЕ И ШИФРОВАНИЕ ТОКЕНА

//    public String generateJwtToken(Authentication authentication) {

    // TODO     UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

//        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }

    // ПОДТВЕРЖДАЕМ ТОКЕН
    public boolean validateJwtToken(String jwt) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
            return true;
        } catch (MalformedJwtException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public String getUserNameFromJwtToken(String jwt) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
    }

}