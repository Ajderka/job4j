package ru.job4j.array;

/**
 * Class  6.7. Квадратный массив заполнен true или false по диагоналям.[#91020].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 12.12.2018.
 */
public class MatrixCheck {

    /**
     * Method mono - определяет массив заполнен только true или false по двум диагоналям квадрата.
     *
     * @param data - вводим массив типа boolean.
     * @return true если массив заполнен только true или толко false по диагоналям, если в перемешку то выводит false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        for (int height = 0, width = 0; width < size - 1; width++, height++) {
            if (data[height][width] != data[height + 1][width + 1] || data[height][(size - 1) - width] != data[height + 1][(size - 2) - width]) {
                result = false;
                break;
            }
        }
        return result;
    }
}