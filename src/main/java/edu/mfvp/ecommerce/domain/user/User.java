package edu.mfvp.ecommerce.domain.user;

public record User(
        Long id,
        String name,
        String email,
        String phone,
        String password
) {
}
