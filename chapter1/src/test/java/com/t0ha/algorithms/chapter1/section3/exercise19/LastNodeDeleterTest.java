package com.t0ha.algorithms.chapter1.section3.exercise19;

import com.t0ha.algorithms.chapter1.section3.exercise19.LastNodeDeleter.Node;
import org.junit.jupiter.api.Test;

import static com.t0ha.algorithms.chapter1.section3.exercise19.LastNodeDeleter.Node.lastNode;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LastNodeDeleterTest {
    @Test
    void lastNode_isDeleted() {
        //given
        Node beforeLast = new Node(lastNode());
        Node first = new Node(new Node(beforeLast));
        //when
        LastNodeDeleter.delete(first);
        //then
        assertTrue(beforeLast.isLast());
    }
}
