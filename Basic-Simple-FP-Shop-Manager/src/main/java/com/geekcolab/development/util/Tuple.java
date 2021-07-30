package com.geekcolab.development.util;

import java.util.List;

public class Tuple<K, V> {
    private K key;
    private V value;

    public Tuple() {
    }

    public Tuple(List<K> key, V value) {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
