package com.t0ha.algorithms.chapter1.section1.exercise11;

import org.junit.jupiter.api.Test;

import static com.t0ha.algorithms.chapter1.section1.exercise11.TwoDimensionalBooleanPrinter.NEWLINE;
import static com.t0ha.algorithms.chapter1.section1.exercise11.TwoDimensionalBooleanPrinter.generateString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TwoDimensionalBooleanPrinterTests {
    @Test
    void starOrSpace_areGeneratedForEachElement() {
        //given
        boolean[][] a = {
                {true, false},
                {true, true, false, true},
                {false, false, true}
        };
        String expected = "" +
                "  0 1 2 3 " + NEWLINE +
                "0 *   " + NEWLINE +
                "1 * *   * " + NEWLINE +
                "2     * " + NEWLINE;
        //when
        String generated = generateString(a);
        //then
        assertThat(generated, is(expected));
    }
}
