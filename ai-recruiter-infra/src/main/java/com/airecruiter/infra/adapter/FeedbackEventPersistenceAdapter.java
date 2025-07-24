package com.airecruiter.infra.adapter;

import com.airecruiter.contract.dto.FeedbackResponseDTO;
import com.airecruiter.contract.port.FeedbackEventPort;
import com.airecruiter.data.entity.FeedbackEventEntity;
import com.airecruiter.data.repository.FeedbackEventRepository;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class FeedbackEventPersistenceAdapter implements FeedbackEventPort {

    private final FeedbackEventRepository repository;

    @Override
    public void save(String userId, String questionId, FeedbackResponseDTO feedback) {
        repository.save(FeedbackEventEntity.builder()
                .userId(userId)
                .questionId(questionId)
                .score(feedback.getScore())
                .message(feedback.getMessage())
                .createdAt(Instant.now())
                .build()
        );
    }
}
