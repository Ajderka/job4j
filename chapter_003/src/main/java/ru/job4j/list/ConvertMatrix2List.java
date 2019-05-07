package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.03.2019.
 */
public class ConvertMatrix2List {

    /**
     * Метод принимает двумерный массив и преобразует его в список.
     *
     * @param array двумерный массив.
     * @return список типа Integer.
     */
    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}