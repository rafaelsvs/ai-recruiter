package com.airecruiter.infra.client;

import com.airecruiter.contract.dto.*;
import com.airecruiter.core.domain.port.AiClientPort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AiPythonClient implements AiClientPort {

    @Override
    public List<String> fetchQuestions(InterviewContextRequest context) {
        return Arrays.asList(
                "Explique uma decisão técnica difícil que você tomou.",
                "Como você lida com conflitos dentro do time?",
                "Quais métricas você acompanha em produção?"
        );
    }

    @Override
    public FeedbackResponseDTO evaluateAnswer(AnswerSubmissionRequest request) {
        return FeedbackResponseDTO.builder()
                .userId(request.getUserId())
                .questionId(request.getQuestionId())
                .score(80)
                .message("Sua resposta mostrou domínio, mas poderia explorar mais exemplos concretos.")
                .build();
    }
}
