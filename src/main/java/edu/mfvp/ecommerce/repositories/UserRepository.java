package edu.mfvp.ecommerce.repositories;

import edu.mfvp.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
