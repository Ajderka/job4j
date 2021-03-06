package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 29.01.2019.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private List<Integer> range = new ArrayList<>();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Test проверяющий нличие определенной ошибки.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Please enter validate data again.%n")));
    }

    /**
     * Test проверяющий нличие определенной ошибки.
     */
    @Test
    public void whenInvalidSelectKeyMenu() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"10", "1"}));
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Please select key from menu.%n")));
    }
}