package com.airecruiter.contract.dto;

public class AnswerSubmissionRequest {
    private String userId;
    private String questionId;
    private String question;
    private String answer;
    private String role;
    private String seniority;
    private String domain;

    public String getUserId() {
        return userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }
}
