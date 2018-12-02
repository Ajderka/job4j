package ru.job4j.condition;

/**
 * Class 3.4. Расстояние между точками в системе координат[#91030].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @version 1
 * @since 02.12.2018
 */
public class Point {

    /**
     * поля x,y на оси координат.
     */
    private int x;
    private int y;

    /**
     * конструктор - инициализация точки в системе координат.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method distanceTo - дистанция до точки.
     *
     * @param that - вторая точка.
     * @return результат.
     */
    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;

        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Конструктор, создаем объекты точек их координаты, вызываем метод distanceTo, выводим на консоль результат.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        a.distanceTo(b);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
