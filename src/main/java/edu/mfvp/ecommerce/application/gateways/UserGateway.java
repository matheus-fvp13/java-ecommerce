package edu.mfvp.ecommerce.application.gateways;

import edu.mfvp.ecommerce.domain.entities.User;

import java.util.List;

public interface UserGateway {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
}
