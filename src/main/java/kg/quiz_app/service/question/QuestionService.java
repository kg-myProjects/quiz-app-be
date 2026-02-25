package kg.quiz_app.service.question;

import kg.quiz_app.dto.QuestionDto;

import java.util.UUID;

public interface QuestionService {

    QuestionDto getNextQuestion(UUID categoryId, UUID currentQuestionId);
}
