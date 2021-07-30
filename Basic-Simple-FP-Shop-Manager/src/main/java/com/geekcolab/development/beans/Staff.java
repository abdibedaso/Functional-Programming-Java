package com.geekcolab.development.beans;

import java.util.List;

public class Staff extends Role{

    private Staff manager;
    private List<Order> orders;

    public Staff(){}

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
