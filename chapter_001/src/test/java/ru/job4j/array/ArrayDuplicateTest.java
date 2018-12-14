package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 14.12.2018.
 */
public class ArrayDuplicateTest {

    /**
     * Test вводит массив типо String, чтобы отсеять дубликаты, сравнивая с массивом без них.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] inMassive = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] outMassive = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(inMassive);
        assertThat(result, is(outMassive));
    }
}