package com.airecruiter.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponseDTO {
    private String userId;
    private String questionId;
    private Integer score;
    private String message;
}

