package com.t0ha.algorithms.chapter1.section3.exercise20;

import com.t0ha.algorithms.chapter1.section3.LinkedListNode;

public class LinkedList {
    private LinkedListNode first;

    public LinkedList(LinkedListNode first) {
        this.first = first;
    }

    public void delete(int k) {
        if (k < 0) throw new IllegalArgumentException();
        else if (k == 0) {
            LinkedListNode deleting = first;
            first = first.next;
            deleting.next = null;
        } else {
            int count = 0;
            for (LinkedListNode node = first; node != null; node = node.next) {
                if (count + 1 == k) {
                    LinkedListNode deleting = node.next;
                    node.next = node.next.next;
                    deleting.next = null;
                    return;
                } else count++;
            }
        }
    }

    public LinkedListNode getFirstNode() {
        return first;
    }
}
