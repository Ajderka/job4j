package ru.job4j.Simple;

public class Teacher extends Profession {
    public Teacher(String n, String p) {
        this.name = n;
        this.profession = p;
    }

    public Specialized study(Student student) {
         Specialized spec = new Specialized();
        return spec;
    }
}
