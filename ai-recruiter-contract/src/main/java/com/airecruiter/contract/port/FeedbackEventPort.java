package com.airecruiter.contract.port;

import com.airecruiter.contract.dto.FeedbackResponseDTO;

public interface FeedbackEventPort {
    void save(String userId, String questionId, FeedbackResponseDTO feedback);
}
