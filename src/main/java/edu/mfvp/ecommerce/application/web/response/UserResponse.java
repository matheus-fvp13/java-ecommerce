package edu.mfvp.ecommerce.application.web.response;

import edu.mfvp.ecommerce.domain.user.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String phone
) {
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.id(), user.name(), user.email(), user.phone());
    }
}
