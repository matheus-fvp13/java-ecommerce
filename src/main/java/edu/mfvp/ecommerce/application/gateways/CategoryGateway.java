package edu.mfvp.ecommerce.application.gateways;

import edu.mfvp.ecommerce.domain.entities.Category;

import java.util.List;

public interface CategoryGateway {
    List<Category> findAll();
    Category findById(Long id);
}
