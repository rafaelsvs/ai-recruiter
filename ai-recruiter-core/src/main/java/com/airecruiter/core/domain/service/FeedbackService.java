package com.airecruiter.core.domain.service;

import com.airecruiter.contract.dto.AnswerSubmissionRequest;
import com.airecruiter.contract.dto.FeedbackResponseDTO;

public interface FeedbackService {
    FeedbackResponseDTO processAnswer(AnswerSubmissionRequest request);
}
