package com.example.CHALENGER_4.service;

import com.example.CHALENGER_4.dto.UserRequest;
import com.example.CHALENGER_4.dto.UserResponse;
import com.example.CHALENGER_4.model.User;
import com.example.CHALENGER_4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User(UUID.randomUUID(), request.getName(), request.getEmail());
        return new UserResponse(userRepository.save(user));
    }

    public UserResponse getUserById(UUID id) {
        return userRepository.findById(id)
                .map(UserResponse::new)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
