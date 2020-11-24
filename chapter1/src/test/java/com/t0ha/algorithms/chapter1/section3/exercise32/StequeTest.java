package com.t0ha.algorithms.chapter1.section3.exercise32;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StequeTest {
    @Test
    void contains12_afterPushing21() {
        //given
        Steque<Integer> steque = new Steque<>();
        //when
        steque.push(2);
        steque.push(1);
        //then
        assertThat(steque, contains(1, 2));
    }

    @Test
    void contains12_afterEnqueuing12() {
        //given
        Steque<Integer> steque = new Steque<>();
        //when
        steque.enqueue(1);
        steque.enqueue(2);
        //then
        assertThat(steque, contains(1, 2));
    }

    @Test
    void contains1234_afterPushing21ThenEnqueuing34() {
        //given
        Steque<Integer> steque = new Steque<>();
        //when
        steque.push(2);
        steque.push(1);
        steque.enqueue(3);
        steque.enqueue(4);
        //then
        assertThat(steque, contains(1, 2, 3, 4));
    }

    @Test
    void becomesEmpty_afterPushingAndPoping() {
        //given
        Steque<Integer> steque = new Steque<>();
        //when
        steque.push(1);
        steque.push(2);
        steque.pop();
        steque.pop();
        //then
        assertThat(steque, emptyIterable());
        assertThat(steque.isEmpty(), is(true));
    }

    @Test
    void becomesEmpty_afterEnqueuingAndPoping() {
        //given
        Steque<Integer> steque = new Steque<>();
        //when
        steque.enqueue(1);
        steque.enqueue(2);
        steque.pop();
        steque.pop();
        //then
        assertThat(steque, emptyIterable());
        assertThat(steque.isEmpty(), is(true));
    }
}
