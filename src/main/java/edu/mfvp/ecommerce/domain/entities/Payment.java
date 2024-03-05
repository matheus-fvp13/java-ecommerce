package edu.mfvp.ecommerce.domain.entities;

import java.time.Instant;

public class Payment extends AbstractEntity{
    private Instant moment;
    private Order order;

    public Payment(Long id, Instant moment, Order order) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
