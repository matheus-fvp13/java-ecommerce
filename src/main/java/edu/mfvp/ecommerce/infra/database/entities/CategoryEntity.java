package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.Category;
import jakarta.persistence.Entity;

@Entity(name = "tb_category")
public class CategoryEntity extends AbstractEntity {
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public static CategoryEntity toCategoryEntity(Category category) {
        return new CategoryEntity(category.getId(), category.getName());
    }

    public Category toCategory() {
        return new Category(this.id, this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
