package com.example.CHALENGER_4.dto;

import com.example.CHALENGER_4.model.Course;

import java.util.List;
import java.util.UUID;

public class CourseResponse {
    private UUID id;
    private String name;
    private String description;

    public CourseResponse() {
    }

    // Constructor que recibe un objeto Course
    public CourseResponse(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}