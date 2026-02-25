package kg.quiz_app.service.question;

import kg.quiz_app.dto.QuestionDto;
import kg.quiz_app.model.quiz.Category;
import kg.quiz_app.model.quiz.Question;
import kg.quiz_app.repository.AnswerRepository;
import kg.quiz_app.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final CategoryRepository categoryRepo;
    private final AnswerRepository answerRepo;

    @Override
    public QuestionDto getNextQuestion(UUID userId, UUID categoryId, UUID currentQuestionId) {

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This category not found!"));

        List<UUID> correctlyAnsweredIds = answerRepo
                .findByUserIdAndQuestionCategoryIdAndIsCorrectTrue(userId, categoryId)
                .stream()
                .map(a -> a.getQuestion().getId())
                .toList();

        List<Question> notAnswered = category.getQuestions().stream()
                .filter(q -> !correctlyAnsweredIds.contains(q.getId()))
                .toList();

        if (currentQuestionId != null) {
            notAnswered = notAnswered.stream()
                    .filter(q -> !q.getId().equals(currentQuestionId))
                    .toList();
        }

        if (notAnswered.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "All questions have been answered correctly");
        }

        Question next;
        next = notAnswered.get(new Random().nextInt(notAnswered.size()));

        return new QuestionDto(next.getId(), next.getText(), next.getOptions());
    }
}
