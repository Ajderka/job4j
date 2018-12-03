package ru.job4j.max;

/**
 * Class  4.2. Максимум из двух чисел[#91003]
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @since 03.12.2018
 * @version 1
 */
public class Max {

    /**
     * Method max - Максимум из двух чисел.
     * @param first - первый аргумент выражения.
     * @param second - второй аргумент выражения.
     */
    public int max(int first, int second) {
        return first < second ? second : first;
    }

}
