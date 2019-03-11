package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 12.03.2019.
 */
public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen5() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                5
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenListOfTwoArraysThenConvertToOneList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> input = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6, 7}
        );
        List<Integer> expected = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7
        );
        assertThat(list.convert(input), is(expected));
    }
}
