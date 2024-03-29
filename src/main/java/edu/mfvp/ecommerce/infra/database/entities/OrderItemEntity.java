package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.OrderItem;
import edu.mfvp.ecommerce.infra.database.entities.pk.OrderItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity(name = "tb_order_item")
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false, precision = 10)
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem toOrderItem() {
        return new OrderItem(this.quantity, this.price, this.getProduct().toProduct());
    }

    public OrderEntity getOrderEntity() {
        return id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        id.setOrder(order);
    }

    public ProductEntity getProduct() {
        return id.getProduct();
    }

    public void setProduct(ProductEntity product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity orderItemEntity = (OrderItemEntity) o;
        return Objects.equals(id, orderItemEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
