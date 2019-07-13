package ru.job4j.collectionpro.map;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 13.07.2019.
 */
public class SimpleHashMapTest {
    private SimpleHashMap<User, String> map;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
    }

    @Test
    public void whenAddEqualsThenFalse() {
        User first = new User("John", 0, new GregorianCalendar(1990, 10, 11));
        User second = new User("John", 0, new GregorianCalendar(1990, 10, 11));
        assertThat(map.insert(first, "first"), is(true));
        assertThat(map.insert(second, "second"), is(false));
    }

    @Test
    public void whenAddNonEqualsThenTrue() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        assertThat(map.insert(first, "first"), is(true));
        assertThat(map.insert(second, "second"), is(true));
    }

    @Test
    public void whenGetByKeyAndItExistedThenGetIt() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        map.insert(first, "first");
        map.insert(second, "second");
        assertThat(map.get(first), is("first"));
    }

    @Test
    public void whenGetNonExistedThanNull() {
        assertNull(map.get(new User("Tom", 0, new GregorianCalendar(1990, 1, 1))));
    }

    @Test
    public void resizeTest() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        assertThat(map.capacity(), is(16));
        for (int index = 1; index < 20; index++) {
            map.insert("testKey" + index, "testValue" + index);
        }
        assertThat(map.capacity(), is(32));
    }

    @Test
    public void whenDeleteExistedThanTrue() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        map.insert(first, "first");
        map.insert(second, "second");
        assertTrue(map.delete(first));
    }

    @Test
    public void whenDeleteNotExistedThenFalse() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        assertFalse(map.delete(first));
    }

    @Test
    public void whenIterateThenTrueAndLastFalse() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        map.insert(first, "first");
        map.insert(second, "second");
        Iterator<SimpleHashMap.Node<User, String>> itr = map.iterator();
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenTryNextThenThrowException() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        User third = new User("John", 0, new GregorianCalendar(1990, 10, 11));
        map.insert(first, "first");
        map.insert(second, "second");
        Iterator<SimpleHashMap.Node<User, String>> itr = map.iterator();
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(true));
        map.insert(third, "third");
        System.out.println(itr.next());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenTryHasNextThenThrowException() {
        User first = new User("Ivanna", 1, new GregorianCalendar(1986, 2, 24));
        User second = new User("Andrey", 2, new GregorianCalendar(1992, 1, 22));
        User third = new User("John", 0, new GregorianCalendar(1990, 10, 11));
        map.insert(first, "first");
        map.insert(second, "second");
        Iterator<SimpleHashMap.Node<User, String>> itr = map.iterator();
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        map.insert(third, "third");
        assertThat(itr.hasNext(), is(true));
    }
}
