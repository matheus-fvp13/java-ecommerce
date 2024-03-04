package edu.mfvp.ecommerce.infra.database.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.mfvp.ecommerce.domain.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.Instant;

@Entity(name = "tb_order")
public class OrderEntity extends AbstractEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

    public OrderEntity() {
    }

    public OrderEntity(Long id, Instant moment, UserEntity client) {
        super(id);
        this.moment = moment;
        this.client = client;
    }

    public static OrderEntity toOrderEntity(Order order) {
        return new OrderEntity(order.getId(), order.getMoment(), UserEntity.fromUser(order.getClient()));
    }

    public Order toOrder() {
        return new Order(this.id, this.moment, this.client.toUser());
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }
}