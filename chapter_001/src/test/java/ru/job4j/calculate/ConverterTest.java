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
public class ConverterTest {

    /**
     * Test конвертация Рубля в доллар.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Test конвертация Рубля в евро.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Test конвертация Доллара в рубль.
     */
    @Test
    public void when1DollarTo60Ruble() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(60));
    }

    /**
     * Test конвертация Евро в рубль.
     */
    @Test
    public void when1EuroTo70Ruble() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(70));
    }
}