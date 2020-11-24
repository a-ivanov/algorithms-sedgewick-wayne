package com.t0ha.algorithms.chapter1.section3.exercise32;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <em>Steque</em>. A stack-ended queue or steque is a data type that supports push, pop, and
 * enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Steque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        if (isEmpty()) last = first;
        else first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Steque underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
