package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 12.03.2019.
 */
public class ConvertList2Array {

    /**
     * Метод принимает список значений и преобразует их в двумерный массив.
     *
     * @param list входящий список типа Integer.
     * @param rows число столбцов.
     * @return двумерный массив типа int.
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int cell = 0;
        int row = 0;
        for (int i : list) {
            if (cell == cells) {
                cell = 0;
                row++;
            }
            array[row][cell++] = i;
        }
        return array;
    }

    /**
     * Метод принимает список массивов и преобразует их в список.
     *
     * @param list входящий список массивов.
     * @return Список типа Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}