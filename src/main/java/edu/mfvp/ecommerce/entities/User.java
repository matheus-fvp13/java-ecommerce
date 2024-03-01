package edu.mfvp.ecommerce.entities;

import java.util.Objects;

public record User(
        Long id,
        String name,
        String email,
        String phone,
        String password
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
