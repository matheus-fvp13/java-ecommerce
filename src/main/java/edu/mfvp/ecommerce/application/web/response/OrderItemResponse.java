package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.OrderItem;

public record OrderItemResponse(
        String productName,
        Integer quantity,
        Double price,
        Double subTotal
) {

    public static OrderItemResponse fromOrderItem(OrderItem orderItem) {
        return new OrderItemResponse(orderItem.getProduct().getName(), orderItem.getQuantity(), orderItem.getPrice(),
                orderItem.getSubTotal());
    }
}
