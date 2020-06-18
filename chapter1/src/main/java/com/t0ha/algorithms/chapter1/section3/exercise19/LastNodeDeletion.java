package com.t0ha.algorithms.chapter1.section3.exercise19;

public class LastNodeDeletion {
    public static class Node {
        private static final Node LAST_NODE = new Node(null);

        private Node next;

        public Node(Node next) {
            this.next = next;
        }

        public boolean isLast() {
            return next == null;
        }

        public static Node lastNode() {
            return LAST_NODE;
        }
    }

    public static void delete(Node first) {
        if (first.isLast()) return;
        Node current = first;
        while (!isBeforeLast(current)) current = current.next;
        current.next = null;
    }

    private static boolean isBeforeLast(Node node) {
        return node.next.isLast();
    }
}
