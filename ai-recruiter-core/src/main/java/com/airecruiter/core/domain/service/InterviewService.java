package com.airecruiter.core.domain.service;


import com.airecruiter.contract.dto.InterviewContextRequest;
import com.airecruiter.contract.dto.AnswerSubmissionRequest;
import com.airecruiter.contract.dto.FeedbackResponseDTO;
import java.util.List;

public interface InterviewService {
    List<String> generateQuestions(InterviewContextRequest context);
    FeedbackResponseDTO evaluateAnswer(AnswerSubmissionRequest request);
}
