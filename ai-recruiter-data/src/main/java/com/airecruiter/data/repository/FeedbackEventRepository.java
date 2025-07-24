package com.airecruiter.data.repository;

import com.airecruiter.data.entity.FeedbackEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackEventRepository extends JpaRepository<FeedbackEventEntity, Long> {
    List<FeedbackEventEntity> findByUserId(String userId);
}