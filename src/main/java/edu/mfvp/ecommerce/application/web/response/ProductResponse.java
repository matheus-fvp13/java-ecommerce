package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.Product;

public record ProductResponse(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl
) {

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getImgUrl());
    }

}
