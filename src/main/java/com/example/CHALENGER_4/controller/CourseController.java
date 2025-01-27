package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.CourseRequest;
import com.example.CHALENGER_4.dto.CourseResponse;
import com.example.CHALENGER_4.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public CourseResponse createCourse(@RequestBody CourseRequest request) {
        return courseService.createCourse(request);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable UUID id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable UUID id, @RequestBody CourseRequest request) {
        return courseService.updateCourse(id, request);
    }
}
