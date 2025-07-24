package com.airecruiter.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "feedback_event")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String questionId;
    private Integer score;
    private String message;
    private Instant createdAt;
}