package kg.quiz_app.repository;

import kg.quiz_app.model.quiz.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    List<Answer> findByUserIdAndQuestionCategoryIdAndIsCorrectTrue(UUID userId, UUID categoryId);
}
