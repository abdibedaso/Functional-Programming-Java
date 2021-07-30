package com.geekcolab.development.mock;

import com.geekcolab.development.beans.*;

import java.util.ArrayList;
import java.util.List;

public class ShopMock {
    public static List<Shop> getListOfShop(){
        List<Shop> shops = new ArrayList<>();
        List<Staff> staffs = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Limit> limits = new ArrayList<>();
        List<Discount> discounts = new ArrayList<>();

        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        Staff staff5 = new Staff();
        Staff staff6 = new Staff();
        Staff staff7 = new Staff();
        Staff staff8 = new Staff();
        Staff staff9 = new Staff();
        Staff staff10 = new Staff();

        // product limits
//        Limit limitMinValueOf2 = new Limit();
//        limitMinValueOf2.setValue(2);
//        limitMinValueOf2.setType("min");
//
//        Limit limitMaxValueOf12 = new Limit();
//        limitMaxValueOf12.setValue(12);
//        limitMaxValueOf12.setType("max");
//        Limit limitMultipleOf2 = new Limit();
//        limitMultipleOf2.setValue(2);
//        limitMaxValueOf12.setType("multiple");
//
//        // populate limits list
//        limits.add(limitMinValueOf2);
//        limits.add(limitMaxValueOf12);
//        limits.add(limitMultipleOf2);


        // tags
        Tag tag1 = new Tag();
        tag1.setName("books");
        Tag tag2 = new Tag();
        tag2.setName("shoes");
        Tag tag3 = new Tag();
        tag3.setName("t-shirt");

        // discount
        Discount discount1 = new Discount();
        discount1.setDiscountType("blackfriday");
        discount1.setDiscountPercent(5.0);
        Discount discount2 = new Discount();
        discount2.setDiscountType("cybermonday");
        discount2.setDiscountPercent(2.0);

        // populate discounts
        discounts.add(discount1);
        discounts.add(discount2);

        // Product
        Product product1 = new Product();
        product1.setProductName("All Star");
        product1.setLimits(limits);
        product1.setTag(tag2);
        product1.setDiscounts(discounts);

        // min 2 limit
        Limit product1MinLimit = new Limit();
        product1MinLimit.setType("min");
        product1MinLimit.setValue(2);
        limits.add(product1MinLimit);
        //product1MinLimit.setProduct(product1);

        // max 12 limit
        Limit product2MaxLimit = new Limit();
        product2MaxLimit.setValue(12);
        product2MaxLimit.setType("max");
        limits.add(product2MaxLimit);

        Product product2 = new Product();
        product2.setProductName("Aldo");
       // product2.setLimits(limits);
        product2.setTag(tag2);
        product2.setDiscounts(discounts);

        Product product3 = new Product();
        product3.setProductName("Adidas outdoor");
        //product3.setLimits(limits);
        product3.setTag(tag2);
        product3.setDiscounts(discounts);

        Product product4 = new Product();
        product4.setProductName("Brooks");
        //product4.setLimits(limits);
        product4.setTag(tag2);
        product4.setDiscounts(discounts);

        Product product5 = new Product();
        product5.setProductName("Bull");
        //product5.setLimits(limits);
        product5.setTag(tag2);
        product5.setDiscounts(discounts);

        Product product6 = new Product();
        product6.setProductName("Bull");
       // product6.setLimits(limits);
        product6.setTag(tag2);
        product6.setDiscounts(discounts);

        Product product7 = new Product();
        product7.setProductName("Carters");
        //product7.setLimits(limits);
        product7.setTag(tag2);
        product7.setDiscounts(discounts);

        Product product8 = new Product();
        product8.setProductName("Disney shoes");
        //product8.setLimits(limits);
        product8.setTag(tag2);
        product8.setDiscounts(discounts);

        Product product9 = new Product();
        product9.setProductName("Dockers");
        //product9.setLimits(limits);
        product9.setTag(tag2);
        product9.setDiscounts(discounts);

        Product product10 = new Product();
        product10.setProductName("Dingo");
        //product10.setLimits(limits);
        product10.setTag(tag2);
        product10.setDiscounts(discounts);

        //populate shops
        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//        products.add(product4);
//        products.add(product5);
//        products.add(product6);
//        products.add(product7);
//        products.add(product8);
//        products.add(product9);
//        products.add(product10);
        //populate staffs
        staffs.add(staff1);

        Shop shop1 = new Shop();
        shop1.setName("jstore");
        shop1.setStaffs(staffs);
        shop1.setProducts(products);

        // populate shops
        shops.add(shop1);

        return shops;
    }
}
