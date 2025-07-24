package com.airecruiter.core.domain.port;

import com.airecruiter.contract.dto.InterviewContextRequest;
import com.airecruiter.contract.dto.AnswerSubmissionRequest;
import com.airecruiter.contract.dto.FeedbackResponseDTO;

import java.util.List;

public interface AiClientPort {
    List<String> fetchQuestions(InterviewContextRequest context);
    FeedbackResponseDTO evaluateAnswer(AnswerSubmissionRequest request);
}
