package kg.quiz_app.service.category;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.repository.CategoryRepository;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final UserService userService;

    @Override
    public List<CategoryProgressDto> getAllCategoriesWithProgress() {

        UUID userId = userService.getUserByName(TEST_USER_NAME).getId();

        return categoryRepo.findAllWithProgressByUser(userId);
    }
}
