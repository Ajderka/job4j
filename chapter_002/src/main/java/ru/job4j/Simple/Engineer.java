package ru.job4j.Simple;

public class Engineer extends Profession {
    public Engineer(String n, String p) {
        this.name = n;
        this.profession = p;
    }

    public Building buildHouse(House house) {
        Building building = new Building();
        return building;
    }
}
