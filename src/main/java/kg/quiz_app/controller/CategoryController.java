package kg.quiz_app.controller;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.repository.UserRepository;
import kg.quiz_app.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserRepository userRepo;

    @GetMapping("/api/categories")
    public List<CategoryProgressDto> getAllCategories() {

        User user = userRepo.findByName(TEST_USER_NAME)
                .orElseThrow(() -> new RuntimeException("This user not found!"));

        return categoryService.getAllCategoriesWithProgress(user.getId());
    }
}
