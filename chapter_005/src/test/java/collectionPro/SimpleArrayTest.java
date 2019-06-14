package collectionPro;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 14.06.2019.
 */
public class SimpleArrayTest {

    SimpleArray<Integer> integers;

    @Before
    public void beforeAllThings() {
        integers = new SimpleArray<>(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }

    @Test
    public void whenAddElementToArray() {
        integers.add(7);
        assertThat(integers.get(3), is(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenThereIsNoSpaceInTheArray() {
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }

    @Test
    public void whenWeChangeAnArrayCell() {
        integers.set(2, 10);
        assertThat(integers.get(2), is(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tryingToGetACellWhichIsNot() {
        integers.get(5);
    }

    @Test(expected = NoSuchElementException.class)
    public void tryingToGetACellWhichIsNull() {
        integers.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tryingToSetACellWhichIsNot() {
        integers.set(5, 10);
    }

    @Test
    public void whenDeleteItemInArray() {
        integers.remove(1);
        assertThat(integers.get(1), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteItemInArrayWhichIsNot() {
        integers.remove(6);
    }

    @Test
    public void whenHasNextTrueIfArrayHaveSpace() {
        Iterator itr = integers.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(3));
        assertThat(itr.hasNext(), is(false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRemoveThenException() {
        Iterator itr = integers.iterator();
        itr.remove();
    }


    @Test(expected = NoSuchElementException.class)
    public void whenCallNextThenNoSuchElementsInArray() {
        Iterator itr = integers.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
    }
}