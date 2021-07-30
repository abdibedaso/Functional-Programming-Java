package com.geekcolab.development.beans;

import java.util.List;

public class Customer extends Role{
    private String email;
    private List<Order> orders;

    public Customer(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
