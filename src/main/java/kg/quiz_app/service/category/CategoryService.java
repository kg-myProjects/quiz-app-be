package kg.quiz_app.service.category;

import kg.quiz_app.dto.CategoryProgressDto;

import java.util.List;

public interface CategoryService {

    List<CategoryProgressDto> getAllCategoriesWithProgress();
}
