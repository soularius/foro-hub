package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.CourseRequest;
import com.example.CHALENGER_4.dto.CourseResponse;
import com.example.CHALENGER_4.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
