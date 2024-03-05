package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.entities.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String phone
) {
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getFirstName() + " " + user.getLastName(),
                user.getEmail(), user.getPhone());
    }
}
