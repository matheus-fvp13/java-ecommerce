package edu.mfvp.ecommerce.infra.database.gateways;

import edu.mfvp.ecommerce.application.gateways.CategoryGateway;
import edu.mfvp.ecommerce.domain.entities.Category;
import edu.mfvp.ecommerce.infra.database.entities.CategoryEntity;
import edu.mfvp.ecommerce.infra.database.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepositoryGateway implements CategoryGateway {
    private CategoryRepository categoryRepository;

    public CategoryRepositoryGateway(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryEntity::toCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category id not found."))
                .toCategory();
    }
}
