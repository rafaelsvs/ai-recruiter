-- Criação de schema
CREATE SCHEMA IF NOT EXISTS airecruiter;

-- Criação da tabela de perguntas
CREATE TABLE IF NOT EXISTS airecruiter.interview_question (
    id SERIAL PRIMARY KEY,
    question_text TEXT NOT NULL,
    category VARCHAR(100),
    difficulty VARCHAR(50)
);

-- Carga inicial
INSERT INTO airecruiter.interview_question (question_text, category, difficulty) VALUES
('Tell me about a time you solved a complex problem.', 'behavioral', 'medium'),
('Explain the difference between a thread and a process.', 'technical', 'easy'),
('What is the time complexity of quicksort?', 'technical', 'medium');

-- Criação da tabela feedback_event
CREATE TABLE IF NOT EXISTS airecruiter.feedback_event (
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    question_id VARCHAR(255),
    score INTEGER,
    message TEXT,
    created_at TIMESTAMP
);
