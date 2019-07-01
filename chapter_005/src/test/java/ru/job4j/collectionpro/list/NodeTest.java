package ru.job4j.collectionpro.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 1.07.2019.
 */
public class NodeTest {
    private Node first;
    private Node second;
    private Node third;
    private Node four;
    private Node five;

    @Before
    public void beforeTest() {
        first = new Node(1);
        second = new Node(2);
        third = new Node(3);
        four = new Node(4);
        five = new Node(5);
    }

    @Test
    public void whenWeDoFullCycle() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenDoSmallCycle() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = second;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenWeDidNotHaveCycle() {
        first.next = second;
        second.next = third;
        third.next = four;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenWeDoBigCycle() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenWeDoNotBigCycle() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        assertThat(first.hasCycle(first), is(false));
    }
}