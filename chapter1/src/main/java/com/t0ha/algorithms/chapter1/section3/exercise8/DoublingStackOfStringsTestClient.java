package com.t0ha.algorithms.chapter1.section3.exercise8;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class DoublingStackOfStringsTestClient {
    public static void main(String[] args) {
        DoublingStackOfStrings s = new DoublingStackOfStrings();
        String[] input = {"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-", "-"};
        printArrayInfo(s);
        for (String item : input) {
            if (!item.equals("-"))
                s.push(item);
            else s.pop();
            printArrayInfo(s);
        }
    }

    private static void printArrayInfo(DoublingStackOfStrings s) {
        StdOut.println("Array contents: " + Arrays.toString(s.a) + " (size=" + s.a.length + ")");
    }

    static class DoublingStackOfStrings {
        private String[] a = new String[1];
        private int n;

        void push(String str) {
            if (n == a.length) resize(2 * a.length);
            a[n++] = str;
        }

        String pop() {
            String str = a[--n];
            a[n] = null;
            if (n > 0 && n == a.length / 4) resize(a.length / 2);
            return str;
        }

        private void resize(int max) {
            a = Arrays.copyOf(a, max);
        }
    }
}
