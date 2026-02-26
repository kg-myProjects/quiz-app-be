package kg.quiz_app.service.answer;

import jakarta.transaction.Transactional;
import kg.quiz_app.model.quiz.Answer;
import kg.quiz_app.model.quiz.Question;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.repository.AnswerRepository;
import kg.quiz_app.repository.QuestionRepository;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepo;
    private final QuestionRepository questionRepo;
    private final UserService userService;

    @Transactional
    @Override
    public boolean submitAnswer(UUID questionId, int selectedAnswerIndex) {

        User user = userService.getUserByName(TEST_USER_NAME);

        Question question = questionRepo.findById(questionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found!"));

        if (selectedAnswerIndex < 0 || selectedAnswerIndex >= question.getOptions().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid answer index");
        }

        boolean isCorrect = question.getCorrectIndex() == selectedAnswerIndex;

        Answer answer = new Answer(user, question, isCorrect);
        answerRepo.save(answer);

        return isCorrect;
    }
}
