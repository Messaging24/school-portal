package com.jm.project.schooljournal.payload.response;

import java.util.List;

public class AuthenticationResponse {
    private String username;
    private List<String> roles;
    private String accessToken;
    private String refreshToken;

    public AuthenticationResponse(String username,
                                  List<String> roles,
                                  String accessToken,
                                  String refreshToken) {
        this.username = username;
        this.roles = roles;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AuthenticationResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
