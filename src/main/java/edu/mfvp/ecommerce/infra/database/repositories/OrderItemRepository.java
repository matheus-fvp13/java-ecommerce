package edu.mfvp.ecommerce.infra.database.repositories;

import edu.mfvp.ecommerce.infra.database.entities.OrderItemEntity;
import edu.mfvp.ecommerce.infra.database.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPK> {
}
