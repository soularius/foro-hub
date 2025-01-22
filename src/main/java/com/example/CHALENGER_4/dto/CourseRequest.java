package com.example.CHALENGER_4.dto;

public class CourseRequest {
    private String name;
    private String description;

    public CourseRequest() {
    }

    public CourseRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}