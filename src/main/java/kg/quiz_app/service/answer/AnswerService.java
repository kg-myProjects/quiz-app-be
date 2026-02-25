package kg.quiz_app.service.answer;

import java.util.UUID;

public interface AnswerService {

    boolean submitAnswer(UUID questionId, int selectedAnswer);
}
