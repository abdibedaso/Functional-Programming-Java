package com.geekcolab.development.beans;

public class Limit {
    private String type;
    private int value;

    public Limit() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
