package edu.mfvp.ecommerce.infra.database.entities;

import edu.mfvp.ecommerce.domain.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_user")
public class UserEntity extends AbstractEntity {
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(length = 14)
    private String phone;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String lastName, String email, String phone, String password) {
        super(id);
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User toUser() {
        return new User(this.id, this.firstName, this.lastName, this.email, this.phone, this.password);
    }

    public static UserEntity fromUser(User user) {
        return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getPassword());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }
}
