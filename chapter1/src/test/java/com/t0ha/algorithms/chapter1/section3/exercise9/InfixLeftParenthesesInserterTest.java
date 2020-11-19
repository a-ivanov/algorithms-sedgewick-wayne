package com.t0ha.algorithms.chapter1.section3.exercise9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class InfixLeftParenthesesInserterTest {
    @ParameterizedTest
    @ValueSource(strings = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )")
    void leftParenthesesAreInserted_afterProcessing(String expression) {
        //given
        InfixLeftParenthesesInserter parenthesesInserter = new InfixLeftParenthesesInserter();
        //when
        for (char c : expression.toCharArray()) {
            parenthesesInserter.accept(c);
        }
        //then
        assertThat(parenthesesInserter.getProcessedExpression(), is("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"));
    }
}
