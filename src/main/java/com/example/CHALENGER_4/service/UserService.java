package com.example.CHALENGER_4.service;

import com.example.CHALENGER_4.dto.UserRequest;
import com.example.CHALENGER_4.dto.UserResponse;
import com.example.CHALENGER_4.model.Course;
import com.example.CHALENGER_4.model.User;
import com.example.CHALENGER_4.repository.CourseRepository;
import com.example.CHALENGER_4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public UserService(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
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
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(UUID id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return new UserResponse(userRepository.save(user));
    }

    public UserResponse enrollUserToCourse(UUID userId, UUID courseId) {
        // Buscar al usuario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Buscar el curso
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Agregar el curso al usuario
        if (!user.getCourses().contains(course)) {
            user.getCourses().add(course);
        }

        // Guardar los cambios
        return new UserResponse(userRepository.save(user));
    }
}
