package com.geekcolab.development.mock;

import com.geekcolab.development.beans.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerMock {

    Shop yamShopping;

    List<Discount> firstDiscounts, secondDiscounts;
    List<Limit> firstLimits, secondLimits, thirdLimits, fourthLimits;
    Tag blackColourTag, redColourTag, mediumPinkTag, largeGreenTag;

    List<Product> firstProducts, secondProducts, thirdProducts, fourthProducts;
    Order firstOrder, secondOrder, thirdOrder, fourthOrder;
    Payment firstPayment, secondPayment, thirdPayment, fourthPayment;

    List<Staff> staffs;
    List<Customer> customers;

    Customer customerAbdi, customerWinta, customerTerbinios, customerFkadu, customerNeba;
    Staff staffAbdi, staffYoseph, staffMerone, staffSofi, staffAlazar;


    public CustomerMock() {

        //creating tags
        blackColourTag = MockFactory.createTag("Black Color");
        redColourTag = MockFactory.createTag("Red Color");
        mediumPinkTag = MockFactory.createTag("Medium Pink Color");
        largeGreenTag = MockFactory.createTag("Large Green Color");

        //creating discounts
        firstDiscounts = List.of(
                MockFactory.createDiscount("Summer Deal", 2, 3)
        );
        secondDiscounts = List.of(
                MockFactory.createDiscount("Summer Deal", 2, 3),
                MockFactory.createDiscount("Holiday Deals", 5, 1)
        );

        //creating discounts
        firstLimits = List.of(
                MockFactory.createLimit("min", 1),
                MockFactory.createLimit("max", 10),
                MockFactory.createLimit("daily", 10)
        );
        secondLimits = List.of(
                MockFactory.createLimit("min", 1),
                MockFactory.createLimit("max", 10)
        );
        thirdLimits = List.of(
                MockFactory.createLimit("max", 10)
        );
        fourthLimits = List.of(
                MockFactory.createLimit("max", 100)
        );

        //creating products
        firstProducts = List.of(
                MockFactory.createProduct("T-shirt", "Clothes", "...", firstDiscounts, blackColourTag, firstLimits),
                MockFactory.createProduct("Pants", "Clothes", "...", secondDiscounts, blackColourTag, secondLimits)
        );

        secondProducts = List.of(
                MockFactory.createProduct("Jackets", "Clothes", "...", firstDiscounts, redColourTag, firstLimits),
                MockFactory.createProduct("WebCam", "Electronics", "...", new ArrayList<>(), blackColourTag, new ArrayList<>()),
                MockFactory.createProduct("Keyboard", "Electronics", "...", new ArrayList<>(), mediumPinkTag, thirdLimits)
        );

        thirdProducts = List.of(
                MockFactory.createProduct("Lamp", "Gadgets", "...", new ArrayList<>(), mediumPinkTag, fourthLimits),
                MockFactory.createProduct("Desk Clock", "Gadgets", "...", new ArrayList<>(), blackColourTag, fourthLimits),
                MockFactory.createProduct("Outlet", "Gadgets", "...", new ArrayList<>(), redColourTag, fourthLimits)
        );

        fourthProducts = List.of(
                MockFactory.createProduct("Pencil", "Stationary", "...", new ArrayList<>(), blackColourTag, new ArrayList<>()),
                MockFactory.createProduct("Prince Pen", "Stationary", "...", new ArrayList<>(), blackColourTag, fourthLimits),
                MockFactory.createProduct("Staple", "Stationary", "...", new ArrayList<>(), blackColourTag, fourthLimits)
        );

        //creating staffs
        staffs = List.of(
                staffAbdi = MockFactory.createStaff("Abdi", "T"),
                staffYoseph = MockFactory.createStaff("Yoseph", "B"),
                staffMerone = MockFactory.createStaff("Meron", "G"),
                staffSofi = MockFactory.createStaff("Sofia", "A"),
                staffAlazar = MockFactory.createStaff("Alazar", "K")
        );



        //creating customers
        customers = List.of(
                customerAbdi = MockFactory.createCustomer("Abdi", "T", "abdi@g.com"),
                customerWinta = MockFactory.createCustomer("Winta", "Y", "winta@g.com"),
                customerTerbinios = MockFactory.createCustomer("Terbinios", "T", "terbinios@g.com"),
                customerFkadu = MockFactory.createCustomer("Fkadu", "S", "fkadu@g.com"),
                customerNeba = MockFactory.createCustomer("Neba", "H", "neba@g.com")
        );


        //createPayment
        firstPayment = MockFactory.createPayment(12d, 2200);
        secondPayment = MockFactory.createPayment(15d, 5200);
        thirdPayment = MockFactory.createPayment(20d, 8600);
        fourthPayment = MockFactory.createPayment(2d, 250);

        //creating Orders
        firstOrder = MockFactory.createOrder(LocalDateTime.now(), firstPayment);
        secondOrder = MockFactory.createOrder(LocalDateTime.now(), secondPayment);
        thirdOrder = MockFactory.createOrder(LocalDateTime.now(), thirdPayment);
        fourthOrder = MockFactory.createOrder(LocalDateTime.now(), fourthPayment);

        //assignPayment
        firstPayment = MockFactory.assignPayment(firstPayment, firstOrder, firstProducts);
        secondPayment = MockFactory.assignPayment(secondPayment, secondOrder, secondProducts);
        thirdPayment = MockFactory.assignPayment(thirdPayment, thirdOrder, thirdProducts);
        fourthPayment = MockFactory.assignPayment(fourthPayment, fourthOrder, fourthProducts);

        //assign orders for Customer
        customerAbdi = MockFactory.assignCustomer(customerAbdi, List.of(firstOrder, thirdOrder));
        customerWinta = MockFactory.assignCustomer(customerWinta, List.of(fourthOrder));
        customerNeba = MockFactory.assignCustomer(customerNeba, List.of(secondOrder));

        firstOrder = MockFactory.assignOrder(firstOrder, List.of(customerAbdi));
        thirdOrder = MockFactory.assignOrder(thirdOrder, List.of(customerAbdi));
        fourthOrder = MockFactory.assignOrder(firstOrder, List.of(customerWinta));
        secondOrder = MockFactory.assignOrder(secondOrder, List.of(customerNeba));

        staffYoseph = MockFactory.assignStaff(staffYoseph, List.of(firstOrder, fourthOrder));
        staffMerone = MockFactory.assignStaff(staffMerone, List.of(thirdOrder));
        staffSofi = MockFactory.assignStaff(staffSofi, List.of(secondOrder));

        //creating shop
        yamShopping = MockFactory.createShop("YAM", Stream.concat(firstProducts.stream(), secondProducts.stream()).collect(Collectors.toList()), staffs);

    }

    public Shop getYamShopping() {
        return yamShopping;
    }

    public void setYamShopping(Shop yamShopping) {
        this.yamShopping = yamShopping;
    }

    public List<Discount> getFirstDiscounts() {
        return firstDiscounts;
    }

    public void setFirstDiscounts(List<Discount> firstDiscounts) {
        this.firstDiscounts = firstDiscounts;
    }

    public List<Discount> getSecondDiscounts() {
        return secondDiscounts;
    }

    public void setSecondDiscounts(List<Discount> secondDiscounts) {
        this.secondDiscounts = secondDiscounts;
    }

    public List<Limit> getFirstLimits() {
        return firstLimits;
    }

    public void setFirstLimits(List<Limit> firstLimits) {
        this.firstLimits = firstLimits;
    }

    public List<Limit> getSecondLimits() {
        return secondLimits;
    }

    public void setSecondLimits(List<Limit> secondLimits) {
        this.secondLimits = secondLimits;
    }

    public List<Limit> getThirdLimits() {
        return thirdLimits;
    }

    public void setThirdLimits(List<Limit> thirdLimits) {
        this.thirdLimits = thirdLimits;
    }

    public List<Limit> getFourthLimits() {
        return fourthLimits;
    }

    public void setFourthLimits(List<Limit> fourthLimits) {
        this.fourthLimits = fourthLimits;
    }

    public Tag getBlackColourTag() {
        return blackColourTag;
    }

    public void setBlackColourTag(Tag blackColourTag) {
        this.blackColourTag = blackColourTag;
    }

    public Tag getRedColourTag() {
        return redColourTag;
    }

    public void setRedColourTag(Tag redColourTag) {
        this.redColourTag = redColourTag;
    }

    public Tag getMediumPinkTag() {
        return mediumPinkTag;
    }

    public void setMediumPinkTag(Tag mediumPinkTag) {
        this.mediumPinkTag = mediumPinkTag;
    }

    public Tag getLargeGreenTag() {
        return largeGreenTag;
    }

    public void setLargeGreenTag(Tag largeGreenTag) {
        this.largeGreenTag = largeGreenTag;
    }

    public List<Product> getFirstProducts() {
        return firstProducts;
    }

    public void setFirstProducts(List<Product> firstProducts) {
        this.firstProducts = firstProducts;
    }

    public List<Product> getSecondProducts() {
        return secondProducts;
    }

    public void setSecondProducts(List<Product> secondProducts) {
        this.secondProducts = secondProducts;
    }

    public List<Product> getThirdProducts() {
        return thirdProducts;
    }

    public void setThirdProducts(List<Product> thirdProducts) {
        this.thirdProducts = thirdProducts;
    }

    public List<Product> getFourthProducts() {
        return fourthProducts;
    }

    public void setFourthProducts(List<Product> fourthProducts) {
        this.fourthProducts = fourthProducts;
    }

    public Order getFirstOrder() {
        return firstOrder;
    }

    public void setFirstOrder(Order firstOrder) {
        this.firstOrder = firstOrder;
    }

    public Order getSecondOrder() {
        return secondOrder;
    }

    public void setSecondOrder(Order secondOrder) {
        this.secondOrder = secondOrder;
    }

    public Order getThirdOrder() {
        return thirdOrder;
    }

    public void setThirdOrder(Order thirdOrder) {
        this.thirdOrder = thirdOrder;
    }

    public Order getFourthOrder() {
        return fourthOrder;
    }

    public void setFourthOrder(Order fourthOrder) {
        this.fourthOrder = fourthOrder;
    }

    public Payment getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(Payment firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Payment getSecondPayment() {
        return secondPayment;
    }

    public void setSecondPayment(Payment secondPayment) {
        this.secondPayment = secondPayment;
    }

    public Payment getThirdPayment() {
        return thirdPayment;
    }

    public void setThirdPayment(Payment thirdPayment) {
        this.thirdPayment = thirdPayment;
    }

    public Payment getFourthPayment() {
        return fourthPayment;
    }

    public void setFourthPayment(Payment fourthPayment) {
        this.fourthPayment = fourthPayment;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomerAbdi() {
        return customerAbdi;
    }

    public void setCustomerAbdi(Customer customerAbdi) {
        this.customerAbdi = customerAbdi;
    }

    public Customer getCustomerWinta() {
        return customerWinta;
    }

    public void setCustomerWinta(Customer customerWinta) {
        this.customerWinta = customerWinta;
    }

    public Customer getCustomerTerbinios() {
        return customerTerbinios;
    }

    public void setCustomerTerbinios(Customer customerTerbinios) {
        this.customerTerbinios = customerTerbinios;
    }

    public Customer getCustomerFkadu() {
        return customerFkadu;
    }

    public void setCustomerFkadu(Customer customerFkadu) {
        this.customerFkadu = customerFkadu;
    }

    public Customer getCustomerNeba() {
        return customerNeba;
    }

    public void setCustomerNeba(Customer customerNeba) {
        this.customerNeba = customerNeba;
    }

    public Staff getStaffAbdi() {
        return staffAbdi;
    }

    public void setStaffAbdi(Staff staffAbdi) {
        this.staffAbdi = staffAbdi;
    }

    public Staff getStaffYoseph() {
        return staffYoseph;
    }

    public void setStaffYoseph(Staff staffYoseph) {
        this.staffYoseph = staffYoseph;
    }

    public Staff getStaffMerone() {
        return staffMerone;
    }

    public void setStaffMerone(Staff staffMerone) {
        this.staffMerone = staffMerone;
    }

    public Staff getStaffSofi() {
        return staffSofi;
    }

    public void setStaffSofi(Staff staffSofi) {
        this.staffSofi = staffSofi;
    }

    public Staff getStaffAlazar() {
        return staffAlazar;
    }

    public void setStaffAlazar(Staff staffAlazar) {
        this.staffAlazar = staffAlazar;
    }
}
