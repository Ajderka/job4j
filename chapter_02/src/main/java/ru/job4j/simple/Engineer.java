package ru.job4j.simple;

/**
 * Class Emgineer - дочерний класс Profession, принимает заявку на постройку дома
 * и строит его.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Engineer extends Profession {
    public Engineer(String n, String p) {
        this.setName(n);
        this.setProfession(p);
    }

    public Building buildHouse(House house) {
        Building building = new Building();
        return building;
    }
}
