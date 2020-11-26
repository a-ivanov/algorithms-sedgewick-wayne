package com.t0ha.algorithms.chapter1.section4.exercise37;

public class FixedCapacityStackOfInts {
    private final int[] a;
    private int n;

    public FixedCapacityStackOfInts(int cap) {
        this.a = new int[cap];
    }

    public void push(int i) {
        a[n++] = i;
    }

    public int pop() {
        return a[--n];
    }
}
