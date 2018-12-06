package ru.job4j.loop;

/**
 * Class  5.3. Построить шахматную доску в псевдографике.[#91013].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 06.12.2018.
 */
public class Board {

    /**
     * Method paint - должен рисовать шахматную доску из символов x и пробелов;.
     *
     * @param width  - ширина доски.
     * @param height - высота доски.
     * @return screen.toString() - возвращает все добавленные в него символы и строки в одну строку .
     */
    public String paint(int width, int height) {

        /*
         * Для сложения строк используем класс StringBuilder.
         */
        StringBuilder screen = new StringBuilder();

        /*
         *  Высота доски достигается за счёт переходов на новую линию.
         *  необходимо использовать System.getProperty("line.separator").
         */
        String ln = System.lineSeparator();

        /*
         * Здесь 2 цикла - внешний отвечает за высоту доски, вложенный отвечает за ширину доски.
         */
        for (int ver = 1; ver <= height; ver++) {
            for (int hor = 1; hor <= width; hor++) {

                /*
                 * индексы попадаются на крестики когда их сумма делится на 2 без остатка.
                 */
                if ((ver + hor) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
