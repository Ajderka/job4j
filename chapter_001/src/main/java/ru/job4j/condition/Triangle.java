package ru.job4j.condition;

/**
 * Class  4.3. Вычисление площади треугольника[#91006].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @version 1
 * @since 02.12.2018
 */
public class Triangle {

    /**
     * Переменные класса типа Point.
     *
     * @param a - точка а.
     * @param b - точка b.
     * @param c - точка c.
     */
    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор принимает координаты трех точек и присваевает(с помощью this) их переменным класса.
     *
     * @param a - точка а.
     * @param b - точка b.
     * @param c - точка c.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * Формула.
     * (ab + ac + bc) / 2.
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return Периметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(
                    p * (p - ab) * (p - ac) * (p - bc)
            );
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     * Ответ: длинна одной из сторон должна быть больше, чем сумма двух других.
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return true or false.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab < ac + bc && ac < ab + bc && bc < ab + ac;
    }
}