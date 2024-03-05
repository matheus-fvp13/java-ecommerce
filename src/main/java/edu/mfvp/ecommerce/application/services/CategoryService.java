package edu.mfvp.ecommerce.application.services;

import edu.mfvp.ecommerce.application.gateways.CategoryGateway;
import edu.mfvp.ecommerce.domain.entities.Category;

import java.util.List;

public class CategoryService {
    private final CategoryGateway categoryGateway;

    public CategoryService(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<Category> findAll() {
        return categoryGateway.findAll();
    }

    public Category findById(Long id) {
        return categoryGateway.findById(id);
    }
}
