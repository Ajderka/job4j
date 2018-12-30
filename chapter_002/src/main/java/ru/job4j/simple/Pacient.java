package ru.job4j.simple;

/**
 * Class  Pacient - пациент доктора, имеет имя.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Pacient {
    private String name;

    public Pacient(String n) {
        this.name = n;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}
