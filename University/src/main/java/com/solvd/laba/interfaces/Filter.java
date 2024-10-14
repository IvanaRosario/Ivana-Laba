package com.solvd.laba.interfaces;

@FunctionalInterface
public interface Filter<T> {
    boolean test(T t);
}
