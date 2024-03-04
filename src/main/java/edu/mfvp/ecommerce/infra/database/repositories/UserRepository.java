package edu.mfvp.ecommerce.infra.database.repositories;

import edu.mfvp.ecommerce.infra.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}