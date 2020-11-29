package com.t0ha.algorithms.chapter1.section3.exercise33;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Circular doubly-linked list implementation.
 *
 * @param <Item> the generic type of an item in this deque
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> last;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> prev;
        private Node<Item> next;
    }

    /**
     * Returns true if this deque is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this deque.
     *
     * @return the number of items in this deque
     */
    public int size() {
        return n;
    }

    /**
     * Adds an item to the left end of this deque.
     *
     * @param item the item to add
     */
    public void pushLeft(Item item) {
        Node<Item> newfirst = new Node<>();
        newfirst.item = item;
        if (isEmpty()) {
            setSoleNode(newfirst);
        } else {
            Node<Item> oldfirst = last.next;
            newfirst.prev = last;
            newfirst.next = oldfirst;
            last.next = newfirst;
            oldfirst.prev = newfirst;
        }
        n++;
    }

    /**
     * Adds an item to the right end of this deque.
     *
     * @param item the item to add
     */
    public void pushRight(Item item) {
        Node<Item> newlast = new Node<>();
        newlast.item = item;
        if (isEmpty()) {
            setSoleNode(newlast);
        } else {
            Node<Item> oldlast = last;
            Node<Item> first = last.next;
            newlast.prev = oldlast;
            newlast.next = first;
            last = newlast;
            first.prev = newlast;
            oldlast.next = newlast;
        }
        n++;
    }

    private void setSoleNode(Node<Item> node) {
        last = node;
        node.prev = node;
        node.next = node;
    }

    /**
     * Removes and returns an item from the left end of this deque.
     *
     * @return the item most recently added to the left end
     */
    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Node<Item> oldfirst = last.next;
        Node<Item> newfirst = oldfirst.next;
        last.next = newfirst;
        newfirst.prev = last;
        n--;
        return oldfirst.item;
    }

    /**
     * Removes and returns an item from the right end of this deque.
     *
     * @return the item most recently added to the right end
     */
    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Node<Item> oldlast = last;
        Node<Item> first = oldlast.next;
        Node<Item> newlast = oldlast.prev;
        newlast.next = first;
        first.prev = newlast;
        n--;
        return oldlast.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private Node<Item> current = last.next;
            private boolean isAtStart = true;

            @Override
            public boolean hasNext() {
                return isAtStart || current != last.next;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                isAtStart = false;
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
