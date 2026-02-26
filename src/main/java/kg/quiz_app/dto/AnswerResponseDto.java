package kg.quiz_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class AnswerResponseDto {

    @Getter(AccessLevel.NONE)
    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
