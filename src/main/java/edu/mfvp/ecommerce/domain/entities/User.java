package edu.mfvp.ecommerce.domain.entities;

import edu.mfvp.ecommerce.domain.entities.AbstractEntity;
import edu.mfvp.ecommerce.domain.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private List<Order> orders = new ArrayList<>();

    public User(Long id, String firstName, String lastName, String email, String phone, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public List<Order> getOrders() {
        return orders;
    }
}
