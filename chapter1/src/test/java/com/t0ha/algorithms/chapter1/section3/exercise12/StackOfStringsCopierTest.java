package com.t0ha.algorithms.chapter1.section3.exercise12;

import edu.princeton.cs.algs4.Stack;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class StackOfStringsCopierTest {
    @Test
    void copiedStack_containsSameStringsSameOrder() {
        //given
        Stack<String> stack = new Stack<>();
        stack.push("String 3");
        stack.push("String 2");
        stack.push("String 1");
        //when
        Stack<String> copy = StackOfStringsCopier.copy(stack);
        //then
        assertThat(copy, contains("String 1", "String 2", "String 3"));
    }
}
