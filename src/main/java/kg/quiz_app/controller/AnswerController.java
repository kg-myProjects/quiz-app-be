package kg.quiz_app.controller;

import kg.quiz_app.dto.AnswerRequestDto;
import kg.quiz_app.dto.AnswerResponseDto;
import kg.quiz_app.service.answer.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/api/questions/{id}/answer")
    public AnswerResponseDto submitAnswer(@PathVariable("id") UUID questionId, @RequestBody AnswerRequestDto requestDto) {

        boolean isCorrect = answerService.submitAnswer(questionId, requestDto.getSelectedIndex());
        return new AnswerResponseDto(isCorrect);
    }
}
