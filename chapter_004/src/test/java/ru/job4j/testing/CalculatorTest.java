/*
package ru.job4j.testing;

import org.junit.Test;
import ru.job4j.testing.Calculator;
import ru.job4j.testing.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(1d, 2d, 3d)));
    }
}*/
