package com.geekcolab.development.beans;

public class Discount {

    private String discountType;
    private Double discountPercent;
    private int minItem;

    public Discount() {
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getMinItem() {
        return minItem;
    }

    public void setMinItem(int minItem) {
        this.minItem = minItem;
    }


}
