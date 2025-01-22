package com.example.CHALENGER_4.service;

import com.example.CHALENGER_4.dto.CourseRequest;
import com.example.CHALENGER_4.dto.CourseResponse;
import com.example.CHALENGER_4.model.Course;
import com.example.CHALENGER_4.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseResponse::new)
                .collect(Collectors.toList());
    }

    public CourseResponse createCourse(CourseRequest request) {
        Course course = new Course(UUID.randomUUID(), request.getName(), request.getDescription());
        return new CourseResponse(courseRepository.save(course));
    }

    public CourseResponse getCourseById(UUID id) {
        return courseRepository.findById(id)
                .map(CourseResponse::new)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(UUID id) {
        courseRepository.deleteById(id);
    }
}