package com.example.CHALENGER_4.controller;

import com.example.CHALENGER_4.dto.TopicRequest;
import com.example.CHALENGER_4.dto.TopicResponse;
import com.example.CHALENGER_4.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public TopicResponse createTopic(@RequestBody TopicRequest request) {
        return topicService.createTopic(request);
    }
}

