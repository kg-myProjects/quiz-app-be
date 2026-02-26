package kg.quiz_app.repository;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.model.quiz.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("""
        SELECT new kg.quiz_app.dto.CategoryProgressDto(
            c.id,
            c.title,
            COUNT(q),
            (SELECT COUNT(a)
             FROM Answer a
             WHERE a.question.category = c
               AND a.user.id = :userId
               AND a.isCorrect = true)
        )
        FROM Category c
        LEFT JOIN c.questions q
        GROUP BY c.id, c.title
        ORDER BY c.title ASC
    """)
    List<CategoryProgressDto> findAllWithProgressByUser(@Param("userId") UUID userId);
}
