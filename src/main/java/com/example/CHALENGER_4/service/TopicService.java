package com.example.CHALENGER_4.service;

import com.example.CHALENGER_4.dto.TopicRequest;
import com.example.CHALENGER_4.dto.TopicResponse;
import com.example.CHALENGER_4.model.Course;
import com.example.CHALENGER_4.model.Topic;
import com.example.CHALENGER_4.model.User;
import com.example.CHALENGER_4.repository.CourseRepository;
import com.example.CHALENGER_4.repository.TopicRepository;
import com.example.CHALENGER_4.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<TopicResponse> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(TopicResponse::new)
                .collect(Collectors.toList());
    }

    public TopicResponse createTopic(TopicRequest request) {
        // Recupera el autor desde el UserRepository
        User author = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Recupera el curso desde el CourseRepository
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Crea el Topic con los objetos recuperados
        Topic topic = new Topic(
                UUID.randomUUID(),
                request.getTitle(),
                request.getMessage(),
                request.getStatus(),
                author, // Objeto User
                course  // Objeto Course
        );

        return new TopicResponse(topicRepository.save(topic));
    }

    public TopicResponse getTopicById(UUID id) {
        return topicRepository.findById(id)
                .map(TopicResponse::new)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public void deleteTopic(UUID id) {
        if (!topicRepository.existsById(id)) {
            throw new RuntimeException("Topic not found");
        }
        topicRepository.deleteById(id);
    }

    public TopicResponse updateTopic(UUID id, TopicRequest request) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        User author = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        topic.setTitle(request.getTitle());
        topic.setMessage(request.getMessage());
        topic.setStatus(request.getStatus());
        topic.setAuthor(author);
        topic.setCourse(course);

        return new TopicResponse(topicRepository.save(topic));
    }

    public Page<TopicResponse> getTopicsPaged(Pageable pageable) {
        return topicRepository.findAll(pageable)
                .map(TopicResponse::new);
    }

    public List<TopicResponse> searchTopics(String courseName, int year) {
        return topicRepository.findByCourseNameAndYear(courseName, year).stream()
                .map(TopicResponse::new)
                .collect(Collectors.toList());
    }
}