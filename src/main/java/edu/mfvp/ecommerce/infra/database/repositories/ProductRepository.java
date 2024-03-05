package edu.mfvp.ecommerce.infra.database.repositories;

import edu.mfvp.ecommerce.infra.database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
