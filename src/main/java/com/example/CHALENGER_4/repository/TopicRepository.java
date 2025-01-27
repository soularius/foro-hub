package com.example.CHALENGER_4.repository;

import com.example.CHALENGER_4.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {
    boolean existsByTitleAndMessage(String title, String message);

    @Query("SELECT t FROM Topic t WHERE t.course.name = :courseName AND YEAR(t.createdAt) = :year")
    List<Topic> findByCourseNameAndYear(String courseName, int year);
}