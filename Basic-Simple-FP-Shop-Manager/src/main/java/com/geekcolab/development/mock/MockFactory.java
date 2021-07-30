package com.geekcolab.development.mock;

import com.geekcolab.development.beans.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class MockFactory {


    static public Shop createShop(String name, List<Product> products, List<Staff> staffs){
        Shop shop = new Shop();
        shop.setName(name);
        shop.setProducts(products);
        shop.setStaffs(staffs);

        return shop;
    }

    static public Staff createStaff(String firstName, String lastName){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Staff staff = new Staff();

        if(person.getRoles() != null)
            person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(staff)).stream()).collect(Collectors.toList()));
        else
            person.setRoles(List.of(staff));

        staff.setPerson(person);

        return staff;
    }

    static public Staff assignStaff(Staff staff, List<Order> orders){

        if(staff.getOrders() != null)
            staff.setOrders(Stream.concat(staff.getOrders().stream(), orders.stream()).collect(Collectors.toList()));
        else
            staff.setOrders(orders);

        return staff;
    }

    static public Customer createCustomer(String firstName, String lastName, String email){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setOrders(new ArrayList<>());

        if(person.getRoles() != null)
            person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(customer)).stream()).collect(Collectors.toList()));
        else
            person.setRoles(List.of(customer));

        customer.setPerson(person);

        return customer;
    }

    static public Customer createCustomer(String firstName, String lastName, String email, List<Order> orders){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setOrders(orders);

        if(person.getRoles() != null)
            person.setRoles(Stream.concat(person.getRoles().stream(), new ArrayList<Role>(List.of(customer)).stream()).collect(Collectors.toList()));
        else
            person.setRoles(List.of(customer));

        customer.setPerson(person);

        return customer;
    }


    static public Customer assignCustomer(Customer customer, List<Order> orders){

        if(customer.getOrders() != null)
            customer.setOrders(Stream.concat(customer.getOrders().stream(), orders.stream()).collect(Collectors.toList()));
        else
            customer.setOrders(orders);
        return customer;
    }

    static public Tag createTag(String name){
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    static public Discount createDiscount(String type, double percent, int minItem){
        Discount discount = new Discount();
        discount.setDiscountType(type);
        discount.setDiscountPercent(percent);
        discount.setMinItem(minItem);
        return discount;
    }

    static public Limit createLimit(String type, int value){
        Limit limit = new Limit();
        limit.setType(type);
        limit.setValue(value);
        return limit;
    }

    static public Product createProduct(String productName, String productType, String productDesc, List<Discount> discounts, Tag tag, List<Limit> limits){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductDescription(productDesc);

        product.setDiscounts(discounts);
        product.setTag(tag);
        product.setLimits(limits);

        return product;
    }

    static public Order createOrder(LocalDateTime date,  Payment payment){
        Order order = new Order();
        order.setDateTime(date);
        order.setPayment(payment);


        return order;
    }

    static public Order assignOrder(Order order, Payment payment){
        order.setPayment(payment);

        return order;
    }

    static public Order assignOrder(Order order, List<Customer> customers){
        order.setCustomers(customers);
        return order;
    }

    static public Payment createPayment(double tax, double subTotal){
        Payment payment = new Payment();
        payment.setTax(tax);
        payment.setSubTotal(subTotal);
        return payment;
    }

    static public Payment assignPayment(Payment payment, Order order, List<Product> products){
        payment.setProducts(products);
        payment.setOrders(order);

        return payment;
    }

}
