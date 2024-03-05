package edu.mfvp.ecommerce.application.web.request;

import edu.mfvp.ecommerce.domain.entities.User;

public record UserCreateRequest(
        String name,
        String email,
        String phone,
        String password
) {
    public User toUser() {
        return new User(null, name, email, phone, password);
    }
}
