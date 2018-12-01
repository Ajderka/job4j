package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @since 01.12.2018.
 * @version 1.
 */
public class CalculatorTest {

    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test substract.
     */
    @Test
    public void whenOneSubstractTwo() {
        Calculator calc = new Calculator();
        calc.substract(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }


    /**
     * Test multiple.
     */
    @Test
    public void whenOneMultipleTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
