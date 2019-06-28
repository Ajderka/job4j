package ru.job4j.collectionpro.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 26.06.2019.
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    @Test
    public void whenPushThenGetElement() {
        stack.push(5);
        assertThat(stack.get(4), is(5));
        assertThat(stack.get(3), is(4));
        assertThat(stack.get(2), is(3));
        assertThat(stack.get(1), is(2));
        assertThat(stack.get(0), is(1));

    }

    @Test
    public void whenPollThenReturnDeleteElement() {
        assertThat(stack.poll(), is(1));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(4));
    }
}