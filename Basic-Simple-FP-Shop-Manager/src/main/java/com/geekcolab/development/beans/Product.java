package com.geekcolab.development.beans;

import java.util.List;

public class Product {
    private String productName;
    private String productType;
    private String productDescription;
    private List<Limit> limits;
    private Tag tag;
    private List<Discount> discounts;

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<Limit> getLimits() {
        return limits;
    }

    public void setLimits(List<Limit> lists) {
        this.limits = lists;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", limits=" + limits +
                ", tag=" + tag +
                ", discounts=" + discounts +
                '}';
    }
}
