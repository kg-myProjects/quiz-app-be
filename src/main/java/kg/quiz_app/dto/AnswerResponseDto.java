package kg.quiz_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResponseDto {

    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
