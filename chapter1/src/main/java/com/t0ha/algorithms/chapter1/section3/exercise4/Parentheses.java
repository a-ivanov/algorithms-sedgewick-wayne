package com.t0ha.algorithms.chapter1.section3.exercise4;

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
    private static final String OPENING = "([{";

    private final Stack<Character> pars = new Stack<>();
    private boolean balanced = true;

    public void accept(char c) {
        if (isOpening(c)) pars.push(c);
        else if (')' == c) determine('(');
        else if (']' == c) determine('[');
        else if ('}' == c) determine('{');
    }

    public boolean areBalanced() {
        return balanced;
    }

    private boolean isOpening(char par) {
        return OPENING.indexOf(par) >= 0;
    }

    private void determine(char balancing) {
        char par = pars.pop();
        balanced = balanced && par == balancing;
    }
}
