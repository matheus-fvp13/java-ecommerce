package edu.mfvp.ecommerce.application.config;

import edu.mfvp.ecommerce.application.gateways.OrderGateway;
import edu.mfvp.ecommerce.application.services.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    OrderService createOrderService(OrderGateway orderGateway) {
        return new OrderService(orderGateway);
    }
}
