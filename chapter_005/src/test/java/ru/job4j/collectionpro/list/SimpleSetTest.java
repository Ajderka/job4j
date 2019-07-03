package ru.job4j.collectionpro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.07.2019.
 */
public class SimpleSetTest {
    SimpleSet<String> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
        set.add("First");
        set.add("Second");
        set.add("Third");
    }

    @Test
    public void whenCheckSizeAfterAddThreeElements() {
        assertThat(set.size(), is(3));
    }

    @Test
    public void whenWeAddAnExistingElementItShouldNotBeAdded() {
        set.add("First");
        assertThat(set.size(), is(3));
    }

    @Test
    public void whenWeCheckIteratorWork() {
        Iterator itr = set.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("First"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Second"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Third"));
        assertThat(itr.hasNext(), is(false));
    }
}