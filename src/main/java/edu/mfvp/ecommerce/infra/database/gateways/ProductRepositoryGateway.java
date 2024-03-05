package edu.mfvp.ecommerce.infra.database.gateways;

import edu.mfvp.ecommerce.application.gateways.ProductGateway;
import edu.mfvp.ecommerce.domain.entities.Product;
import edu.mfvp.ecommerce.infra.database.entities.ProductEntity;
import edu.mfvp.ecommerce.infra.database.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryGateway implements ProductGateway {
    private final ProductRepository productRepository;

    public ProductRepositoryGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductEntity::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!")).toProduct();
    }
}
