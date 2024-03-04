package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.Order;

import java.time.Instant;

public record OrderResponse(
        Long id,
        Instant moment,
        UserResponse client
) {
    public static OrderResponse fromOrder(Order order) {
        return new OrderResponse(order.getId(), order.getMoment(), UserResponse.toUserResponse(order.getClient()));
    }
}
