package com.t0ha.algorithms.chapter1.section3.exercise10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class InfixToPostfixTest {
    @ParameterizedTest
    @CsvSource({
            "(A + B), A B +",
            "((A + B) * C), A B + C *",
            "(((A + B) * C) - ((D - E) * (F + G))), A B + C * D E - F G + * -"
    })
    void infixExpression_isConvertedToPostfix(String infixExpression, String postfixExpression) {
        //given
        InfixToPostfix filter = new InfixToPostfix();
        //when
        for (char c : infixExpression.toCharArray()) {
            filter.accept(c);
        }
        //then
        assertThat(filter.getConvertedExpression(), is(postfixExpression));
    }
}
