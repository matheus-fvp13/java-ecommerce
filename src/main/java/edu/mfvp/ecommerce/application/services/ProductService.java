package edu.mfvp.ecommerce.application.services;

import edu.mfvp.ecommerce.application.gateways.ProductGateway;
import edu.mfvp.ecommerce.domain.entities.Product;

import java.util.List;

public class ProductService {
    private final ProductGateway productGateway;

    public ProductService(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> findAll() {
        return productGateway.findAll();
    }

    public Product findById(Long id) {
        return productGateway.findById(id);
    }
}
