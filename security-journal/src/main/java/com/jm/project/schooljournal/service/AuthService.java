package com.jm.project.schooljournal.service;

import com.jm.project.schooljournal.exception.TokenRefreshException;
import com.jm.project.schooljournal.model.RefreshToken;
import com.jm.project.schooljournal.model.User;
import com.jm.project.schooljournal.payload.request.LoginRequest;
import com.jm.project.schooljournal.payload.request.RefreshTokenRequest;
import com.jm.project.schooljournal.payload.response.AuthenticationResponse;
import com.jm.project.schooljournal.payload.response.RefreshTokenResponse;
import com.jm.project.schooljournal.security.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    public AuthService(AuthenticationManager authenticationManager, RefreshTokenService refreshTokenService) {
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword())
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userDetails = (User) authentication.getPrincipal();
        String accessToken = JwtUtil.generateToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(role -> role.getAuthority().substring(5))
                .collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.generateRefreshToken(userDetails.getId());
        return new AuthenticationResponse(userDetails.getUsername(),
                roles, accessToken, refreshToken.getToken());
    }

    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = JwtUtil.generateTokenByUsername(user.getUsername());
                    return new RefreshTokenResponse(token, requestRefreshToken);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
}
