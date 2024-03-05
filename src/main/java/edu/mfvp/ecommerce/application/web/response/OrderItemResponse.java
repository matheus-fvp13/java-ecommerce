package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.OrderItem;

public record OrderItemResponse(
        String productName,
        Integer quantuty,
        Double price
) {

    public static OrderItemResponse fromOrderItem(OrderItem orderItem) {
        return new OrderItemResponse(orderItem.getProduct().getName(), orderItem.getQuantity(), orderItem.getPrice());
    }
}
