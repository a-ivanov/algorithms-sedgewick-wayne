package com.t0ha.algorithms.chapter1.section3.exercise6;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class QueueReverseOrderTest {
    @Test
    void queueElementsOrderIsReversed_whenPushElementsToStackAndPopOneByOne() {
        //given
        Queue<String> q = new Queue<>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        assertThat(q, contains("1", "2", "3"));
        //when
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
        //then
        assertThat(q, contains("3", "2", "1"));
    }
}
