package ru.job4j.array;

/**
 * Class  6.0. Заполнить массив степенями чисел.[#91015].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 09.12.2018.
 */
public class Square {

    /**
     * поле переменная для цыкла.
     */
    int i = 1;

    /**
     * Method calculate -  заполняет массив числами возведенными в квадрат (от 1 до bound).
     *
     * @param bound - количество ячеек в массиве.
     * @return массив заполненный числами.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index != bound; index++) {
            rst[index] = (int) Math.pow(i++, 2);
        }
        return rst;
    }
}