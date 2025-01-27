package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.UserRequest;
import com.example.CHALENGER_4.dto.UserResponse;
import com.example.CHALENGER_4.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable UUID id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @PutMapping("/{userId}/enroll/{courseId}")
    public UserResponse enrollUserToCourse(@PathVariable UUID userId, @PathVariable UUID courseId) {
        return userService.enrollUserToCourse(userId, courseId);
    }
}
