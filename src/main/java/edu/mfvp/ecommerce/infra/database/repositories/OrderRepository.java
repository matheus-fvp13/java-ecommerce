package edu.mfvp.ecommerce.infra.database.repositories;

import edu.mfvp.ecommerce.infra.database.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
