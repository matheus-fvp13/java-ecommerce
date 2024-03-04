package edu.mfvp.ecommerce.infra.database.gateways;

import edu.mfvp.ecommerce.application.gateways.OrderGateway;
import edu.mfvp.ecommerce.domain.Order;
import edu.mfvp.ecommerce.infra.database.entities.OrderEntity;
import edu.mfvp.ecommerce.infra.database.repositories.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;

    public OrderRepositoryGateway(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream().map(OrderEntity::toOrder).collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!")).toOrder();
    }
}
