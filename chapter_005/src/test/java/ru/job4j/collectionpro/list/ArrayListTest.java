package ru.job4j.collectionpro.list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 28.06.2019.
 */
public class ArrayListTest {
    private ArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenDeleteFirstElement() {
        assertThat(list.remove(1), is(2));
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(3));
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void whenCallConstructorAndGetSizeThat() {
        ArrayList<Integer> arrayList = new ArrayList<>(15);
        assertThat(list.getSizeContainer(), is(10));
        assertThat(arrayList.getSizeContainer(), is(15));
    }

    @Test
    public void whenWeCallNextAndHasNext() {
        Iterator<Integer> itr = list.iterator();
        assertThat(itr.next(),is(1));
        assertThat(itr.hasNext(),is(true));
        assertThat(itr.next(),is(2));
        assertThat(itr.hasNext(),is(true));
        assertThat(itr.next(),is(3));
        assertThat(itr.hasNext(),is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void whenRemoveThenException() {
        Iterator<Integer> itr = list.iterator();
        itr.remove();
    }
}