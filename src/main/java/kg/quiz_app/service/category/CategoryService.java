package kg.quiz_app.service.category;

import kg.quiz_app.dto.CategoryProgressDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryProgressDto> getAllCategoriesWithProgress(UUID userId);
}
