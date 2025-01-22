package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.UserRequest;
import com.example.CHALENGER_4.dto.UserResponse;
import com.example.CHALENGER_4.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
