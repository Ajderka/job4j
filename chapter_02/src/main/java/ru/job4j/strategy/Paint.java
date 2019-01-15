package ru.job4j.strategy;

/**
 * Class Paint.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 15.01.2019.
 */
public class Paint {

    /**
     * Метод реализует вывод информации в консоль.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
