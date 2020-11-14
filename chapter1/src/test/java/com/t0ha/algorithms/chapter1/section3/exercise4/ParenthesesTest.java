package com.t0ha.algorithms.chapter1.section3.exercise4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ParenthesesTest {
    @ParameterizedTest
    @ValueSource(strings = "[()]{}{[()()]()}")
    void trueIsReturned_whenBalanced(String seq) {
        //given
        Parentheses parentheses = new Parentheses();
        //when
        for (char c : seq.toCharArray()) {
            parentheses.accept(c);
        }
        //then
        assertThat(parentheses.areBalanced(), is(true));
    }

    @ParameterizedTest
    @ValueSource(strings = { "[(])", "[({)}]" })
    void falseIsReturned_whenNotBalanced(String seq) {
        //given
        Parentheses parentheses = new Parentheses();
        //when
        for (char c : seq.toCharArray()) {
            parentheses.accept(c);
        }
        //then
        assertThat(parentheses.areBalanced(), is(false));
    }
}
