package edu.mfvp.ecommerce.application.web.request;

import edu.mfvp.ecommerce.domain.entities.User;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String phone
) {
    public User toUser() {
        return new User(null, firstName, lastName, email, phone, null);
    }
}
