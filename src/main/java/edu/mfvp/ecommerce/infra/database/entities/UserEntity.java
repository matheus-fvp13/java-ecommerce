package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_user")
public class UserEntity extends AbstractEntity {
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, String phone, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User toUser() {
        return new User(this.id, this.name, this.email, this.phone, this.password);
    }

    public static UserEntity fromUser(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }
}
