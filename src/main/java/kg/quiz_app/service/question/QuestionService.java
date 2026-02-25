package kg.quiz_app.service.question;

import kg.quiz_app.dto.QuestionDto;

import java.util.UUID;

public interface QuestionService {

    QuestionDto getNextQuestion(UUID userId, UUID categoryId, UUID currentQuestionId);
}
