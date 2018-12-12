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
        for (int height1 = 0, width1 = 0; width1 < data.length - 1; width1++, height1++) {
            if (data[height1][width1] != data[height1 + 1][width1 + 1]) {
                result = false;
                break;
            }
        }

        for (int height2 = 0, width2 = data.length - 1; width2 > 0; width2--, height2++) {
            if (data[height2][width2] != data[height2 + 1][width2 - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}