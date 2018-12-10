package ru.job4j.array;

/**
 * Class  6.0. Заполнить массив степенями чисел.[#91015].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.12.2018.
 */
public class FindLoop {

    /**
     * Method calculate -  заполняет массив числами возведенными в квадрат (от 1 до bound).
     *
     * @param data - вводим массив типа int.
     * @param el   - число которое ищем в массиве.
     * @return индекс массива под которым находится это число.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != el; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}