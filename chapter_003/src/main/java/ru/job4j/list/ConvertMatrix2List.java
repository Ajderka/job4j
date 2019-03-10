package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.03.2019.
 */
public class ConvertMatrix2List {

    /**
     * Метод принимает двумеорный массив и преобразует их в список.
     *
     * @param array двумерный массив.
     * @return список типа Integer.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}