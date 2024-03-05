package edu.mfvp.ecommerce.application.config;

import edu.mfvp.ecommerce.application.gateways.ProductGateway;
import edu.mfvp.ecommerce.application.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    ProductService create(ProductGateway productGateway) {
        return new ProductService(productGateway);
    }
}
