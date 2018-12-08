package ru.job4j.loop;

/**
 * Class  5.4. Построить пирамиду в псевдографике.[#91012].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.12.2018.
 */
public class Paint {

    /**
     * Method paint - должен рисовать правую сторону пирамиды из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return screen.toString() - возвращает все добавленные в него символы и строки в одну строку .
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Method paint - должен рисовать левую сторону пирамиды из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return screen.toString() - возвращает все добавленные в него символы и строки в одну строку .
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Method paint - должен рисовать пирамиду из символа ^ и пробелов;.
     *
     * @param height - высота пирамиды.
     * @return screen.toString() - возвращает все добавленные в него символы и строки в одну строку .
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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