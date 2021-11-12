package com.jm.project.schooljournal.service;

import com.jm.project.schooljournal.exception.NotFoundException;
import com.jm.project.schooljournal.exception.TokenRefreshException;
import com.jm.project.schooljournal.exception.UserAlreadyExistException;
import com.jm.project.schooljournal.model.RefreshToken;
import com.jm.project.schooljournal.model.RoleModel;
import com.jm.project.schooljournal.model.User;
import com.jm.project.schooljournal.payload.request.LoginRequest;
import com.jm.project.schooljournal.payload.request.RefreshTokenRequest;
import com.jm.project.schooljournal.payload.request.RegisterRequest;
import com.jm.project.schooljournal.payload.response.AuthenticationResponse;
import com.jm.project.schooljournal.payload.response.MessageResponse;
import com.jm.project.schooljournal.payload.response.RefreshTokenResponse;
import com.jm.project.schooljournal.repository.RoleRepository;
import com.jm.project.schooljournal.repository.UserRepository;
import com.jm.project.schooljournal.security.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RefreshTokenService refreshTokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public MessageResponse register(RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        if (userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistException(username);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        RoleModel role = roleRepository
                .findByRole("ROLE_" + registerRequest.getRole().toUpperCase());
        if (role == null) {
            throw new NotFoundException("Role not found");
        }
        Set<RoleModel> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse(
                String.format("User %s registered successfully", username)
        );
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
