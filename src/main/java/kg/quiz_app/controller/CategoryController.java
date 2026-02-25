package kg.quiz_app.controller;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.model.quiz.User;
import kg.quiz_app.service.category.CategoryService;
import kg.quiz_app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kg.quiz_app.config.DataInitializer.TEST_USER_NAME;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("/api/categories")
    public List<CategoryProgressDto> getAllCategories() {

        User user = userService.getUserByName(TEST_USER_NAME);

        return categoryService.getAllCategoriesWithProgress(user.getId());
    }
}
