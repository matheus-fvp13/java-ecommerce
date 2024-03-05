package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.Category;

public record CategoryResponse(
        Long id,
        String name
) {
    public static CategoryResponse fromCategory(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }

    public Category toCategory() {
        return new Category(this.id, this.name);
    }
}
