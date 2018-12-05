package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @version 1
 * @since 05.12.2018
 */
public class MaxTest {

    /**
     * Test Максимум из трех чисел.
     */
    @Test
    public void whenFirstLessSecondLessThree() {
        Max maxim = new Max();
        int result = maxim.maxThree(1, 2, 3);
        assertThat(result, is(3));

    }
}