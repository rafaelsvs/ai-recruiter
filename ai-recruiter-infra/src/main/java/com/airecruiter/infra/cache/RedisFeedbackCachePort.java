package com.airecruiter.infra.cache;

import com.airecruiter.contract.cache.FeedbackCachePort;
import com.airecruiter.contract.dto.FeedbackResponseDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisFeedbackCachePort implements FeedbackCachePort {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisFeedbackCachePort(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private String buildKey(String userId, String questionId) {
        return "feedback:" + userId + ":" + questionId;
    }

    @Override
    public void save(String userId, String questionId, FeedbackResponseDTO response, Duration ttl) {
        redisTemplate.opsForValue().set(buildKey(userId, questionId), response, ttl);
    }

    @Override
    public FeedbackResponseDTO get(String userId, String questionId) {
        Object value = redisTemplate.opsForValue().get(buildKey(userId, questionId));
        return value instanceof FeedbackResponseDTO ? (FeedbackResponseDTO) value : null;
    }
}
