// core/src/main/java/com/airecruiter/core/domain/service/impl/InterviewServiceImpl.java
package com.airecruiter.core.domain.service.impl;

import com.airecruiter.contract.dto.*;
import com.airecruiter.core.domain.port.AiClientPort;
import com.airecruiter.core.domain.service.InterviewService;
import org.springframework.stereotype.Service;
import com.airecruiter.core.domain.service.FeedbackService;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final AiClientPort aiClient; // você pode até remover se não usar mais diretamente
    private final FeedbackService feedbackService;

    public InterviewServiceImpl(AiClientPort aiClient, FeedbackService feedbackService) {
        this.aiClient = aiClient;
        this.feedbackService = feedbackService;
    }

    @Override
    public List<String> generateQuestions(InterviewContextRequest context) {
        return aiClient.fetchQuestions(context);
    }

    @Override
    public FeedbackResponseDTO evaluateAnswer(AnswerSubmissionRequest request) {
        return feedbackService.processAnswer(request);
    }
}
