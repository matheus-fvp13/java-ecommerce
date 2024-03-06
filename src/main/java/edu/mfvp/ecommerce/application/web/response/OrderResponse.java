package edu.mfvp.ecommerce.application.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.mfvp.ecommerce.domain.entities.Order;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public record OrderResponse(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment,
        UserResponse client,
        Set<OrderItemResponse> items,
        Double total
) {
    public static OrderResponse fromOrder(Order order) {
        Set<OrderItemResponse> items = order.getItems().stream()
                .map(OrderItemResponse::fromOrderItem)
                .collect(Collectors.toSet());
        return new OrderResponse(order.getId(), order.getMoment(),
                UserResponse.toUserResponse(order.getClient()), items, order.getTotal());
    }
}
