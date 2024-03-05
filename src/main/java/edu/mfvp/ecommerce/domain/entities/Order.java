package edu.mfvp.ecommerce.domain.entities;

import edu.mfvp.ecommerce.domain.enums.OrderStatus;

import java.time.Instant;

public class Order extends AbstractEntity {
    Long id;
    Instant moment;
    Integer orderStatus;
    User client;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        super(id);
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null)
            this.orderStatus = orderStatus.getCode();
    }

    public User getClient() {
        return client;
    }

    public void setClient(User user) {
        this.client = user;
    }
}
