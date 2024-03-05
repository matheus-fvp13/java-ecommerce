package edu.mfvp.ecommerce.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Category extends AbstractEntity {

    private String name;

    private Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
