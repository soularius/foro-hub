package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.TopicRequest;
import com.example.CHALENGER_4.dto.TopicResponse;
import com.example.CHALENGER_4.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<TopicResponse> getAllTopics() {
        return topicService.getAllTopics();
    }

    @PostMapping
    public TopicResponse createTopic(@Valid @RequestBody TopicRequest request) {
        return topicService.createTopic(request);
    }

    @GetMapping("/{id}")
    public TopicResponse getTopicById(@PathVariable UUID id) {
        return topicService.getTopicById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable UUID id) {
        topicService.deleteTopic(id);
    }

    @PutMapping("/{id}")
    public TopicResponse updateTopic(@PathVariable UUID id, @RequestBody TopicRequest request) {
        return topicService.updateTopic(id, request);
    }

    @GetMapping("/paged")
    public Page<TopicResponse> getTopicsPaged(
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        return topicService.getTopicsPaged(pageable);
    }

    @GetMapping("/search")
    public List<TopicResponse> searchTopics(
            @RequestParam String courseName,
            @RequestParam int year) {
        return topicService.searchTopics(courseName, year);
    }
}

