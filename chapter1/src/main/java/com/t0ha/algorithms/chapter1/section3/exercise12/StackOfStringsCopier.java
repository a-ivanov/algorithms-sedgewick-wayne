package com.t0ha.algorithms.chapter1.section3.exercise12;

import edu.princeton.cs.algs4.Stack;

public final class StackOfStringsCopier {
    private StackOfStringsCopier() {
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> tmp = new Stack<>();
        Stack<String> copy = new Stack<>();
        for (String s : stack) {
            tmp.push(s);
        }
        for (String s : tmp) {
            copy.push(s);
        }
        return copy;
    }
}
