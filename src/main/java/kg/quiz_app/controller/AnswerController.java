package kg.quiz_app.controller;

import kg.quiz_app.dto.AnswerRequestDto;
import kg.quiz_app.dto.AnswerResponseDto;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.service.answer.AnswerService;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final UserService userService;

    @PostMapping("/api/questions/{id}/answer")
    public AnswerResponseDto submitAnswer(@PathVariable("id") UUID questionId, @RequestBody AnswerRequestDto requestDto) {

        User user = userService.getUserByName(TEST_USER_NAME);

        boolean isCorrect = answerService.submitAnswer(user.getId(), questionId, requestDto.getSelectedIndex());

        return new AnswerResponseDto(isCorrect);
    }
}
