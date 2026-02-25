package kg.quiz_app.controller;

import kg.quiz_app.dto.QuestionDto;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.service.question.QuestionService;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/api/categories/{id}/next-question")
    public QuestionDto getNextQuestion(
            @PathVariable("id") UUID categoryId,
            @RequestParam(value = "currentQuestionId", required = false) UUID currentQuestionId) {

        User user = userService.getUserByName(TEST_USER_NAME);

        return questionService.getNextQuestion(user.getId(), categoryId, currentQuestionId);
    }
}
