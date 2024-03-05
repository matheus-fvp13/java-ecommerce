package edu.mfvp.ecommerce.application.gateways;

import edu.mfvp.ecommerce.domain.entities.Order;

import java.util.List;

public interface OrderGateway {
    List<Order> findAll();
    Order findById(Long id);
}
