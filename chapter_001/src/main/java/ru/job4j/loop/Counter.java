package ru.job4j.loop;

/**
 * Class  5.1. Подсчет суммы чётных чисел в диапазоне[#91009].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 06.12.2018.
 */
public class Counter {

    /**
     * поле: переменная суммы четных чисел.
     */
    int var;

    /**
     * Method add - Метод должен вычислять сумму четныx чисел в диапазоне от start до finish.
     *
     * @param start  - первый аргумент выражения.
     * @param finish - последний аргумент выражения.
     */
    public int add(int start, int finish) {

        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                var = var + index;
            }
        }
        return var;
    }
}