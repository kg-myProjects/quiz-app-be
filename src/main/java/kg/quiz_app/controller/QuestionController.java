package kg.quiz_app.controller;

import kg.quiz_app.dto.QuestionDto;
import kg.quiz_app.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/api/categories/{id}/next-question")
    public QuestionDto getNextQuestion(
            @PathVariable("id") UUID categoryId,
            @RequestParam(value = "currentQuestionId", required = false) UUID currentQuestionId) {

        return questionService.getNextQuestion(categoryId, currentQuestionId);
    }
}
