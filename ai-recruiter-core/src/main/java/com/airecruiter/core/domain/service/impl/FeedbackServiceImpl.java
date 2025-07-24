package com.airecruiter.core.domain.service.impl;

import com.airecruiter.contract.dto.*;
import com.airecruiter.contract.cache.FeedbackCachePort;
import com.airecruiter.contract.port.FeedbackEventPort;
import com.airecruiter.core.domain.service.FeedbackService;
import org.springframework.stereotype.Service;
import com.airecruiter.core.domain.port.AiClientPort;

import java.time.Duration;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackCachePort feedbackCache;
    private final FeedbackEventPort feedbackEventPort;
    private final AiClientPort aiClient;

    public FeedbackServiceImpl(
            FeedbackCachePort feedbackCache,
            FeedbackEventPort feedbackEventPort,
            AiClientPort aiClient) {
        this.feedbackCache = feedbackCache;
        this.feedbackEventPort = feedbackEventPort;
        this.aiClient = aiClient;
    }

    @Override
    public FeedbackResponseDTO processAnswer(AnswerSubmissionRequest request) {
        FeedbackResponseDTO cached = feedbackCache.get(request.getUserId(), request.getQuestionId());
        if (cached != null) return cached;

        FeedbackResponseDTO feedback = aiClient.evaluateAnswer(request);

        feedbackCache.save(request.getUserId(), request.getQuestionId(), feedback, Duration.ofMinutes(10));
        feedbackEventPort.save(request.getUserId(), request.getQuestionId(), feedback);

        return feedback;
    }
}

