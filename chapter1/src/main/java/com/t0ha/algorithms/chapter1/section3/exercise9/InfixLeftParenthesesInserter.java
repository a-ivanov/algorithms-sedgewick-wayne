package com.t0ha.algorithms.chapter1.section3.exercise9;

import edu.princeton.cs.algs4.Stack;

public class InfixLeftParenthesesInserter {
    private final Stack<Character> ops = new Stack<>();
    private final Stack<String> partial = new Stack<>();

    public void accept(char c) {
        switch (c) {
            case '(':
                throw new IllegalArgumentException();
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
                partial.push(String.format("( %s %s %s )", val1, ops.pop(), val2));
                break;
            default:
                partial.push(Character.toString(c));
        }
    }

    public String getProcessedExpression() {
        return partial.pop();
    }
}
