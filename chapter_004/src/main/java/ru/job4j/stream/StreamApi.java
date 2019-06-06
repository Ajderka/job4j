package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 06.06.2019.
 */
public class StreamApi {

    /**
     * Задан массив чисел.
     * 1. Нужно него отфильтровать, оставить только четные числа.
     * 2. Каждое число возвести в квадрат.
     * 3. И все элементы просуммировать.
     */
    public Integer getSum(Integer[] massive) {
        return Stream.of(massive)
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .reduce(0, Integer::sum);
    }
}

