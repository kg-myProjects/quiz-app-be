package kg.quiz_app.repository;

import kg.quiz_app.model.quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
