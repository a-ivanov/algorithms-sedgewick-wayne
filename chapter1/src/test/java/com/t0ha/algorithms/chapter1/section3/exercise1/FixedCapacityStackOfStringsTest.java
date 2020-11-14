package com.t0ha.algorithms.chapter1.section3.exercise1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FixedCapacityStackOfStringsTest {
    @Test
    void isFullReturnsTrue_whenPushOneElementToOneCapacityStack() {
        //given
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(1);
        //when
        stack.push("String");
        //then
        assertThat(stack.isFull(), is(true));
    }

    @Test
    void isFullReturnsFalse_forEmptyStack() {
        //given
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
        //when
        //then
        assertThat(stack.isFull(), is(false));
    }

    @Test
    void isFullReturnsTrue_whenPushAtCapacityPopPushToStack() {
        //given
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
        //when
        stack.push("String 1");
        stack.push("String 2");
        stack.pop();
        stack.push("String 3");
        //then
        assertThat(stack.isFull(), is(true));
    }

    @Test
    void isFullReturnsFalse_whenPushPopFromStack() {
        //given
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
        //when
        stack.push("String 1");
        stack.push("String 2");
        stack.pop();
        //then
        assertThat(stack.isFull(), is(false));
    }
}
