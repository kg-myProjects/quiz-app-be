package kg.quiz_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class QuestionDto {

    private UUID id;
    private String text;
    private List<String> options;
}
