package com.t0ha.algorithms.chapter1.section3.exercise10;

import edu.princeton.cs.algs4.Stack;

public class InfixToPostfix {
    private final Stack<Character> ops = new Stack<>();
    private final Stack<String> partial = new Stack<>();

    public void accept(char c) {
        switch (c) {
            case '(':
            case ' ':
                break;
            case '+':
            case '-':
            case '*':
            case '/':
                ops.push(c);
                break;
            case ')':
                String val2 = partial.pop();
                String val1 = partial.pop();
                partial.push(String.format("%s %s %s", val1, val2, ops.pop()));
                break;
            default:
                partial.push(Character.toString(c));
        }
    }

    public String getConvertedExpression() {
        return partial.pop().trim();
    }
}
