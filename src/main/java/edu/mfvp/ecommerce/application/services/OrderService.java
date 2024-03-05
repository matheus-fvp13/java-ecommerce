package edu.mfvp.ecommerce.application.services;

import edu.mfvp.ecommerce.application.gateways.OrderGateway;
import edu.mfvp.ecommerce.domain.entities.Order;

import java.util.List;

public class OrderService {
    private final OrderGateway orderGateway;

    public OrderService(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public List<Order> findAll() {
        return orderGateway.findAll();
    }

    public Order findById(Long id) {
        return orderGateway.findById(id);
    }
}
