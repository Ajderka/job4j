package collectionPro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.06.2019.
 */
public class EvenIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void whenIteratorReturnFalseIfNoNumbers() {
        it = new EvenIterator(new int[]{4, 2, 1, 1});
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldBeReturnException() {
        it.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenIterator(new int[]{2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}

