package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 20.12.2018.
 */
public class ArraySortTest {

    /**
     * Test ввыводит сортированный массив, состоящий из двух сортированных.
     */
    @Test
    public void combiningTwoArraysIntoOne() {
        ArraySort sortBy = new ArraySort();
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{6, 7, 8, 9, 10, 11};
        int[] result = sortBy.array3(array1, array2);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(result, is(expect));
    }
}
