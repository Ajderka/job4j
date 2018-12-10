package ru.job4j.array;

/**
 * Class  Массив заполнен true или false[#91019].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.12.2018.
 */
public class Check {

    /**
     * Method mono - определяет массив заполнен true или false.
     *
     * @param data - вводим массив типа boolean.
     * @return true если массив заполнен только true или толко false, если в перемешку то выводит false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] == data[index + 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}