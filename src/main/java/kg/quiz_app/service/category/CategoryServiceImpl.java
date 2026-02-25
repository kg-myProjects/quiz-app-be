package kg.quiz_app.service.category;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.model.quiz.Category;
import kg.quiz_app.repository.AnswerRepository;
import kg.quiz_app.repository.CategoryRepository;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final AnswerRepository answerRepo;
    private final UserService userService;

    @Override
    public List<CategoryProgressDto> getAllCategoriesWithProgress() {

        UUID userId = userService.getUserByName(TEST_USER_NAME).getId();

        List<Category> allCategories = categoryRepo.findAll();
        List<Object[]> raw = answerRepo.countCorrectAnswersByUserGroupedByCategory(userId);

        Map<UUID, Long> corAnswersMap = raw.stream()
                .collect(Collectors.toMap(
                        row -> (UUID) row[0],
                        row -> (Long) row[1]
                ));

        return allCategories.stream()
                .sorted(Comparator.comparing(Category::getTitle))
                .map(c -> new CategoryProgressDto(
                        c.getId(),
                        c.getTitle(),
                        c.getQuestions().size(),
                        corAnswersMap.getOrDefault(c.getId(), 0L)
                )).toList();
    }
}
