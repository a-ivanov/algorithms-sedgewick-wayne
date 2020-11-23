package com.t0ha.algorithms.chapter1.section3.exercise20;

import com.t0ha.algorithms.chapter1.section3.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class LinkedListTest {
    @Test
    void firstNode_isDeleted() {
        //given
        LinkedListNode node2 = LinkedListNode.last();
        LinkedListNode node1 = new LinkedListNode(node2);
        LinkedList linkedList = new LinkedList(node1);
        //when
        linkedList.delete(0);
        //then
        assertThat(linkedList.getFirstNode(), is(node2));
    }

    @Test
    void node3_isDeleted() {
        //given
        LinkedListNode node4 = LinkedListNode.last();
        LinkedListNode node3 = new LinkedListNode(node4);
        LinkedListNode node2 = new LinkedListNode(node3);
        LinkedListNode node1 = new LinkedListNode(node2);
        LinkedList linkedList = new LinkedList(node1);
        //when
        linkedList.delete(2);
        //then
        assertThat(node1.next, is(node2));
        assertThat(node2.next, is(node4));
        assertThat(node4.next, is(nullValue(LinkedListNode.class)));
    }
}
