package com.geekcolab.development.util.custom.function;

public interface TriFunction<X, Y, Z, R> {
    R apply(X x, Y y, Z z);
}
