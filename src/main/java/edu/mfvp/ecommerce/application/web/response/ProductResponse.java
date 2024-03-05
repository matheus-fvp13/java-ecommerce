package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record ProductResponse(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<CategoryResponse> categories
) {

    public static ProductResponse fromProduct(Product product) {
        Set<CategoryResponse> categoryResponses = product.getCategories().stream()
                .map(CategoryResponse::fromCategory)
                .collect(Collectors.toSet());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getImgUrl(), categoryResponses);
    }

}
