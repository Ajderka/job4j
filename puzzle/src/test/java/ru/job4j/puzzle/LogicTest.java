package ru.job4j.puzzle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 24.12.2018.
 */
public class LogicTest {

    /**
     * Test вводит масив, где есть выиграшная комбинация.
     */
    @Test
    public void whenVerticalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Test вводит масив, где есть выиграшная комбинация.
     */
    @Test
    public void whenHorizontalWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(true));
    }

    /**
     * Test вводит масив, где нет выиграшной комбинации.
     */
    @Test
    public void whenNotWin() {
        Logic logic = new Logic(5) {
            @Override
            public int[][] convert() {
                return new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                };
            }
        };
        assertThat(logic.isWin(), is(false));
    }
}