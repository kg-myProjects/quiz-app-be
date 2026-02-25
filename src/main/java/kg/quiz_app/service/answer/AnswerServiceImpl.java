package kg.quiz_app.service.answer;

import kg.quiz_app.model.quiz.Answer;
import kg.quiz_app.model.quiz.Question;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.repository.AnswerRepository;
import kg.quiz_app.repository.QuestionRepository;
import kg.quiz_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepo;
    private final UserRepository userRepo;
    private final QuestionRepository questionRepo;

    @Override
    public boolean submitAnswer(UUID userId, UUID questionId, int selectedAnswerIndex) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This user not found!"));

        Question question = questionRepo.findById((questionId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This question not found!"));

        boolean isCorrect = question.getCorrectIndex() == selectedAnswerIndex;

        Answer answer = new Answer(user, question, isCorrect);

        answerRepo.save(answer);

        return isCorrect;
    }
}
