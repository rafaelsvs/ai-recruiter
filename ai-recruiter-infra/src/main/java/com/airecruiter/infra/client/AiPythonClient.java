package com.airecruiter.infra.client;

import com.airecruiter.contract.dto.AnswerSubmissionRequest;
import com.airecruiter.contract.dto.FeedbackResponseDTO;
import com.airecruiter.contract.dto.InterviewContextRequest;
import com.airecruiter.core.domain.port.AiClientPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AiPythonClient implements AiClientPort {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ai.service.url}")
    private String aiServiceUrl;

    @Override
    public List<String> fetchQuestions(InterviewContextRequest context) {
        System.out.println(">>> Enviando para /generateQuestions: " +
                "role=" + context.getRole() +
                ", seniority=" + context.getSeniority() +
                ", domain=" + context.getDomain()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<InterviewContextRequest> entity = new HttpEntity<>(context, headers);

        ResponseEntity<String[]> response = restTemplate.postForEntity(
                aiServiceUrl + "/generateQuestions",
                entity,
                String[].class
        );

        return Arrays.asList(response.getBody());
    }

    @Override
    public FeedbackResponseDTO evaluateAnswer(AnswerSubmissionRequest request) {
        System.out.println(">>> Enviando para /evaluateAnswer: " +
                "userId=" + request.getUserId() +
                ", questionId=" + request.getQuestionId() +
                ", answer=" + request.getAnswer()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AnswerSubmissionRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<FeedbackResponseDTO> response = restTemplate.postForEntity(
                aiServiceUrl + "/evaluateAnswer",
                entity,
                FeedbackResponseDTO.class
        );

        return response.getBody();
    }
}