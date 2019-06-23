package ru.job4j.collectionpro.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.06.2019.
 */
public class IteratorArrayTest {

    @Test
    public void whenIterateMassive() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenSkipZeroCell() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}, {5}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }

}
