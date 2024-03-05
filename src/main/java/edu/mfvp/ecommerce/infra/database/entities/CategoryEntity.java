package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_category")
public class CategoryEntity extends AbstractEntity {
    private String name;

    @Transient
    private Set<ProductEntity> products = new HashSet<>();

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

    public Set<ProductEntity> getProducts() {
        return products;
    }
}
