package com.t0ha.algorithms.chapter1.section3.exercise1;

public class FixedCapacityStackOfStrings {
    private final String[] a;
    private int n;

    public FixedCapacityStackOfStrings(int cap) {
        this.a = new String[cap];
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }

    public boolean isFull() {
        return a.length == n;
    }
}
