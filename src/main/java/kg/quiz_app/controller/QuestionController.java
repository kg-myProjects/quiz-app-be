package kg.quiz_app.controller;

import kg.quiz_app.dto.QuestionDto;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.repository.UserRepository;
import kg.quiz_app.service.question.QuestionService;
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
    private final UserRepository userRepo;

    @GetMapping("/api/categories/{id}/next-question")
    public QuestionDto getNextQuestion(
            @PathVariable("id") UUID categoryId,
            @RequestParam(value = "currentQuestionId", required = false) UUID currentQuestionId) {

        User user = userRepo.findByName(TEST_USER_NAME)
                .orElseThrow(() -> new RuntimeException("This user not found!"));

        return questionService.getNextQuestion(user.getId(), categoryId, currentQuestionId);
    }
}
