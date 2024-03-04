package edu.mfvp.ecommerce.application.gateways;

import edu.mfvp.ecommerce.domain.user.User;

import java.util.List;

public interface UserGateway {
    List<User> findAll();
    User findById(Long id);
}
