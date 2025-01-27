package com.example.CHALENGER_4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class TopicRequest {

    @NotBlank(message = "El título es obligatorio.")
    private String title;

    @NotBlank(message = "El mensaje es obligatorio.")
    private String message;

    @NotNull(message = "El status es obligatorio.")
    private String status;

    @NotNull(message = "El autor es obligatorio.")
    private UUID authorId;

    @NotNull(message = "El curso es obligatorio.")
    private UUID courseId;

    public TopicRequest() {
    }

    public TopicRequest(String title, String message, String status, UUID authorId, UUID courseId) {
        this.title = title;
        this.message = message;
        this.status = status;
        this.authorId = authorId;
        this.courseId = courseId;
    }

    // Getters y Setters
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

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}