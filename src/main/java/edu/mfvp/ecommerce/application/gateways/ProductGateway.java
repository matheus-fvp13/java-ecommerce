package edu.mfvp.ecommerce.application.gateways;

import edu.mfvp.ecommerce.domain.entities.Product;

import java.util.List;

public interface ProductGateway {
    List<Product> findAll();
    Product findById(Long id);
}
