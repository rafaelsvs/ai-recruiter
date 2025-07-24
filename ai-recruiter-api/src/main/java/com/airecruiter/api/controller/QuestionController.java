package com.airecruiter.api.controller;

import com.airecruiter.contract.dto.InterviewContextRequest;
import com.airecruiter.core.domain.service.InterviewService;
import com.airecruiter.contract.dto.AnswerSubmissionRequest;
import com.airecruiter.contract.dto.FeedbackResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final InterviewService interviewService;

    public QuestionController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public ResponseEntity<List<String>> generateQuestions(@RequestBody InterviewContextRequest context) {
        List<String> questions = interviewService.generateQuestions(context);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/feedback")
    public ResponseEntity<FeedbackResponseDTO> evaluateAnswer(@RequestBody AnswerSubmissionRequest request) {
        FeedbackResponseDTO feedback = interviewService.evaluateAnswer(request);
        return ResponseEntity.ok(feedback);
    }
}
