package com.example.example.dto;

import lombok.Data;

@Data
public class UserResponse{

    private String username;
    private String roles; // New field for email
    private String token; // New field for email

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String password) {
        this.token = password;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }



}