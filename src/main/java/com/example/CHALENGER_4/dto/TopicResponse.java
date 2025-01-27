package com.example.CHALENGER_4.dto;

import com.example.CHALENGER_4.model.Course;
import com.example.CHALENGER_4.model.Topic;
import com.example.CHALENGER_4.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class TopicResponse {
    private UUID id;
    private String title;
    private String message;
    private String status;
    private LocalDateTime createdAt;
    private UserResponse author;
    private CourseResponse course;

    public TopicResponse() {
    }

    // Constructor que recibe un objeto Topic
    public TopicResponse(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
        this.status = topic.getStatus();
        this.author = new UserResponse(topic.getAuthor());
        this.course = new CourseResponse(topic.getCourse());
    }

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserResponse getAuthor() {
        return author;
    }

    public void setAuthor(UserResponse author) {
        this.author = author;
    }

    public CourseResponse getCourse() {
        return course;
    }

    public void setCourse(CourseResponse course) {
        this.course = course;
    }
}
