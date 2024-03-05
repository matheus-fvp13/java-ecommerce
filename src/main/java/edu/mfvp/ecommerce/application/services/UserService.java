package edu.mfvp.ecommerce.application.services;

import edu.mfvp.ecommerce.domain.entities.User;
import edu.mfvp.ecommerce.application.gateways.UserGateway;

import java.util.List;

public class UserService {
    private UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<User> findAll() {
        return userGateway.findAll();
    }

    public User findById(Long id) {
        return userGateway.findById(id);
    }

    public User create(User user) {
        return userGateway.create(user);
    }

    public void delete(Long id) {
        if(findById(id) == null) {
            throw new RuntimeException("User not found!");
        }
        userGateway.delete(id);
    }
}
