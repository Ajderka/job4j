package ru.job4j.loop;

/**
 * Class  5.2. Создать программу вычисляющую факториал.[#91010]
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 06.12.2018.
 */
public class Factorial {

    /**
     * поле факториал.
     */
    int fact = 1;

    /**
     * Method calc - В качестве аргумента в метод приходит положительное целое число n, сам метод должен
     * возвращать рассчитанный факториал для этого числа.
     *
     * @param n - приходит положительное целое число n.
     * @return fact - рассчитанный факториал для числа n.
     */
    public int calc(int n) {
        for (int index = 1; index <= n; index++) {
            fact *= index;
        }
        return fact;
    }
}
