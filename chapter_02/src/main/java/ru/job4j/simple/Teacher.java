package ru.job4j.simple;

/**
 * Class Teacher - Учитель, дочерний класс Profession.
 * Учит студентов, на выходе получаются специалисты.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Teacher extends Profession {
    public Teacher(String n, String p) {
        this.setName(n);
        this.setProfession(p);
    }

    public Specialized study(Student student) {
        Specialized spec = new Specialized();
        return spec;
    }
}
