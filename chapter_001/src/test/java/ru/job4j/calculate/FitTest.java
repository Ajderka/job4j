package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @since 01.12.2018.
 * @version 1.
 */
public class FitTest {

    /**
     * Test ideal weight for the man.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test ideal weight for the woman.
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}