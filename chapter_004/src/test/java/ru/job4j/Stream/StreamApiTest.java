package ru.job4j.Stream;

import org.junit.Test;

import ru.job4j.stream.StreamApi;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StreamApiTest {

    @Test
    public void whenAddMassiveOfValues() {
        StreamApi streamApi = new StreamApi();
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer expected = 1540;
        assertThat(streamApi.getSum(values), is(expected));
    }
}
