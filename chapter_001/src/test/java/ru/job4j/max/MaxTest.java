package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @since 03.12.2018
 * @version 1
 */
public class MaxTest {

    /**
     * Test Максимум из двух чисел.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
}
