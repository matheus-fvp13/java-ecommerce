package edu.mfvp.ecommerce.application.config;

import edu.mfvp.ecommerce.application.gateways.CategoryGateway;
import edu.mfvp.ecommerce.application.services.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    CategoryService createCategoryService(CategoryGateway categoryGateway) {
        return new CategoryService(categoryGateway);
    }
}
