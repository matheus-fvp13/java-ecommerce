package edu.mfvp.ecommerce.domain.entities;

import edu.mfvp.ecommerce.domain.enums.OrderStatus;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Order extends AbstractEntity {
    private Long id;
    private Instant moment;
    private Integer orderStatus;
    private User client;
    private Payment payment;
    private Set<OrderItem> items = new HashSet<>();

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
}
