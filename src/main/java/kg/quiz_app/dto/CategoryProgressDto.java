package kg.quiz_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CategoryProgressDto {
    private UUID id;
    private String title;
    private int totalQuestions;
    private Long correctAnswers;
}
