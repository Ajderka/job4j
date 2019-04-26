package ru.job4j.departmens;

import org.junit.Test;
import ru.job4j.departments.Departments;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 20.04.2019.
 */
public class DepartmentsTest {

    @Test
    public void naturalSort() {
        Departments deps = new Departments();
        List<String> input = new ArrayList<>();
        input.add("K1\\SK1");
        input.add("K1\\SK2");
        input.add("K1\\SK1\\SSK1");
        input.add("K1\\SK1\\SSK2");
        input.add("K2");
        input.add("K2\\SK1\\SSK1");
        input.add("K2\\SK1\\SSK2");
        List<String> expect = List.of(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        );
        deps.sortNatural(input);
        assertThat(input, is(expect));
    }

    @Test
    public void reverseSort() {
        Departments deps = new Departments();
        List<String> input = new ArrayList<>();
        input.add("K1");
        input.add("K2");
        input.add("K1\\SK1");
        input.add("K1\\SK1\\SSK1");
        input.add("K1\\SK1\\SSK2");
        input.add("K1\\SK2");
        input.add("K2\\SK1");
        input.add("K2\\SK1\\SSK1");
        input.add("K2\\SK1\\SSK2");
        List<String> expect = List.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );
        deps.sortReverse(input);
        assertThat(input, is(expect));
    }
}