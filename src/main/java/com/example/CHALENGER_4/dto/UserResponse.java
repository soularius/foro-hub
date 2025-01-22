package com.example.CHALENGER_4.dto;

import com.example.CHALENGER_4.model.User;

import java.util.List;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String name;
    private String email;

    public UserResponse() {
    }

    // Constructor que recibe un objeto User
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}