package ru.job4j.Simple;

import java.util.HashSet;
import java.util.Set;

public class Doctor extends Profession {
    public String type;
    public String typeYears;

    public Doctor(String n, String p) {
        this.name = n;
        this.profession = p;
    }
    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }


}
