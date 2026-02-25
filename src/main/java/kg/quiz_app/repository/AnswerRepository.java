package kg.quiz_app.repository;

import kg.quiz_app.model.quiz.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    List<Answer> findByUserIdAndQuestionCategoryIdAndIsCorrectTrue(UUID userId, UUID categoryId);

    @Query("""
            SELECT a.question.category.id, COUNT(a)
            FROM Answer a
            WHERE a.user.id = :userId AND a.isCorrect = true
            GROUP BY a.question.category.id
            """)
    List<Object[]> countCorrectAnswersByUserGroupedByCategory(@Param("userId") UUID userId);
}
