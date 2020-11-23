package com.t0ha.algorithms.chapter1.section3;

public class LinkedListNode {
    public LinkedListNode next;

    public LinkedListNode(LinkedListNode next) {
        this.next = next;
    }

    public static LinkedListNode last() {
        return new LinkedListNode(null);
    }
}
