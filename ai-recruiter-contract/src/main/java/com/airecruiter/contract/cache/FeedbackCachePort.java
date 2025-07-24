package com.airecruiter.contract.cache;

import com.airecruiter.contract.dto.FeedbackResponseDTO;

import java.time.Duration;

public interface FeedbackCachePort {
    void save(String userId, String questionId, FeedbackResponseDTO feedback, Duration ttl);
    FeedbackResponseDTO get(String userId, String questionId);
}

