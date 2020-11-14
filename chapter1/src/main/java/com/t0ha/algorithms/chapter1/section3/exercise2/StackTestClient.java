package com.t0ha.algorithms.chapter1.section3.exercise2;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StackTestClient {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String[] input = {"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-", "-"};
        for (String item : input) {
            if (!item.equals("-"))
                s.push(item);
            else StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
