package com.geekcolab.development.beans;

import java.util.List;

public class Shop {
    private String name;
    private List<Staff> staffs;
    private List<Product> products;

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", staffs=" + staffs +
                ", products=" + products +
                '}';
    }
}
