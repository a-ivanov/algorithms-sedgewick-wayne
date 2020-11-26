package com.t0ha.algorithms.chapter1.section4.exercise37;

public class FixedCapacityStack<Item> {
    private final Item[] a;
    private int n;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        this.a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[n++] = item;
    }

    public Item pop() {
        return a[--n];
    }
}
