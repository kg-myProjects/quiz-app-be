package kg.quiz_app.controller;

import kg.quiz_app.dto.CategoryProgressDto;
import kg.quiz_app.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/api/categories")
    public List<CategoryProgressDto> getAllCategories() {
        return categoryService.getAllCategoriesWithProgress();
    }
}
