package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class  5.5. Рефакторинг кода.[#91008].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 08.12.2018.
 */
class Paint {

    /**
     * Method rightTrl - должен рисовать правую сторону пирамиды из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return Это лямбды - Java 8 - так же этот элемент языка будет рассмотрен в третьем уровне курса.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Method leftTrl - должен рисовать левую сторону пирамиды из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return Это лямбды - Java 8 - так же этот элемент языка будет рассмотрен в третьем уровне курса.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Method pyramid - должен рисовать пирамиду из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return Это лямбды - Java 8 - так же этот элемент языка будет рассмотрен в третьем уровне курса.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Method pyramid - реализующий в себе лямбду и дженерики;.
     *
     * @param height - высота пирамиды.
     * @return  возвращает все добавленные в него символы и строки в одну строку.  .
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}