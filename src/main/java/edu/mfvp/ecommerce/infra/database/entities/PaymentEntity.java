package edu.mfvp.ecommerce.infra.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.time.Instant;

@Entity(name = "tb_payment")
public class PaymentEntity extends AbstractEntity {
    private Instant moment;
    @OneToOne
    @MapsId
    private OrderEntity order;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, Instant moment, OrderEntity order) {
        super(id);
        this.moment = moment;
        this.order = order;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
