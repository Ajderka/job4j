package ru.job4j.collectionpro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 14.07.2019.
 */
public class LinkedListTest {
    private LinkedList<String> list;


    @Before
    public void beforeTest() {
        list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
    }

    @Test
    public void whenAddThreeThanGet() {
        assertThat(list.get(1), is("Second"));
        assertThat(list.get(0), is("Third"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundThenThrowException() {
        list.get(3);
    }

    @Test
    public void whenIterateThenIterable() {
        Iterator<String> itr = list.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Third"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Second"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("First"));
        assertThat(itr.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementThenThrowException() {
        Iterator<String> itr = list.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationChangeThenThrowException() {
        Iterator<String> itr = list.iterator();
        itr.next();
        list.add("Four");
        itr.next();
    }

    @Test
    public void whenDeleteThanDeleted() {
        String result = list.removeFirst();
        assertThat(list.get(0), is("Second"));
        assertThat(result, is("Third"));
    }
}