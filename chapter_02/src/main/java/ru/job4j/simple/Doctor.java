package ru.job4j.simple;

/**
 * Class  Pacient - пациент доктора, имеет имя.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Doctor extends Profession {
    private String type;
    private String typeYears;

    public Doctor(String n, String p) {
        this.setName(n);
        this.setProfession(p);
    }

    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }


}
