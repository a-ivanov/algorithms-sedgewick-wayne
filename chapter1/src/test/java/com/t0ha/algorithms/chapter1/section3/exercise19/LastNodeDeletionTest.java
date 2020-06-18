package com.t0ha.algorithms.chapter1.section3.exercise19;

import com.t0ha.algorithms.chapter1.section3.exercise19.LastNodeDeletion.Node;
import org.junit.jupiter.api.Test;

import static com.t0ha.algorithms.chapter1.section3.exercise19.LastNodeDeletion.Node.lastNode;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LastNodeDeletionTest {
    @Test
    void lastNode_isDeleted() {
        //given
        Node beforeLast = new Node(lastNode());
        Node first = new Node(new Node(beforeLast));
        //when
        LastNodeDeletion.delete(first);
        //then
        assertTrue(beforeLast.isLast());
    }
}
