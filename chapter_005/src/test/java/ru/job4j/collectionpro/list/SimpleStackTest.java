package ru.job4j.collectionpro.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 24.06.2019.
 */
public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    @Test
    public void whenPushThenGetElement() {
        stack.push(5);
        assertThat(stack.get(0), is (5));
    }

    @Test
    public void whenPollThenReturnDeleteElement () {
        assertThat(stack.poll(), is(4));
        assertThat(stack.get(0), is (3));
    }

}