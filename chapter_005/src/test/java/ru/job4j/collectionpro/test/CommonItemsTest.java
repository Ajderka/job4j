package ru.job4j.collectionpro.test;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 29.07.2019.
 */
public class CommonItemsTest {

    private CommonItems commonItems = new CommonItems();

    @Test
    public void findCommonItemsInTwoMassive() {
        Integer[] a = {1, 2, 3};
        Integer[] b = {2, 3, 4};
        Integer[] c = {2, 3};
        assertThat(commonItems.findCommonItems(a, b), is(c));
    }

    @Test
    public void findCommonItemsInTwoMassiveThoughMap() {
        Integer[] a = {1, 2, 3, 5, 6, 7, 8, 9, 6, 5, 4};
        Integer[] b = {2, 3, 4, 3, 6, 7, 8, 4, 5, 11, 23, 45};
        Integer[] c = {2, 3, 4, 5, 6, 7, 8};
        assertThat(commonItems.findCommonItemsThroughMap(a, b), is(c));
    }

}