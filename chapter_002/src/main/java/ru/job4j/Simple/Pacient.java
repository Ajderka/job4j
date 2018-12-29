package ru.job4j.Simple;

public class Pacient {
    public String name;

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
