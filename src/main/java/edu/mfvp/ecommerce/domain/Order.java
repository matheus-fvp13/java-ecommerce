package edu.mfvp.ecommerce.domain;

import java.time.Instant;

public class Order extends AbstractEntity {
    Long id;
    Instant moment;
    User client;

    public Order(Long id, Instant moment, User client) {
        super(id);
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User user) {
        this.client = user;
    }
}
