package ru.job4j.array;

/**
 * Class  6.6. Двухмерный массив. Таблица умножения.[#91017].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 12.12.2018.
 */
public class Matrix {

    /**
     * method multiple - строит матрицу, ячейка которой равна произведению координат.
     *
     * @param size размер матрицы.
     * @return возвращает матрицу с заполненными ячейками.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int height = 1; height <= size; height++) {
            for (int width = 1; width <= size; width++) {
                table[height - 1][width - 1] = (height) * (width);
            }
        }
        return table;
    }
}