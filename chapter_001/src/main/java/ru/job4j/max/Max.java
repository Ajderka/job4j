package ru.job4j.max;

/**
 * Class  4.4. Максимум из трех чисел[#91004].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 05.12.2018.
 */
public class Max {

    /**
     * Method max - Максимум из двух чисел.
     *
     * @param first  - первый аргумент выражения.
     * @param second - второй аргумент выражения.
     */
    public int max(int first, int second) {
        return first < second ? second : first;
    }

    /**
     * Method maxThree - Максимум из трех чисел.
     *
     * @param first  - первый аргумент выражения.
     * @param second - второй аргумент выражения.
     * @param third  - второй аргумент выражения.
     */
    public int maxThree(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

}
