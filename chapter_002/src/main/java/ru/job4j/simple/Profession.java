package ru.job4j.simple;

/**
 * Class  Профессии, родительский класс. 1. Реализация профессий в коде[#91091]
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Profession {
    private String name;
    private String profession;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}