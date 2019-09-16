package ru.job4j.lambda;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 26.04.2019.
 */
public class DaipasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason dia = new Diapason();
        List<Double> result = dia.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Diapason dia = new Diapason();
        List<Double> result = dia.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason dia = new Diapason();
        List<Double> result = dia.diapason(5, 8, x -> Math.log(256) / Math.log(2) + x);
        List<Double> expected = Arrays.asList(13D, 14D, 15D);
        assertThat(result, is(expected));
    }
}
