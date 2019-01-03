package ru.job4j.simple;

/**
 * Class Specialized - готовы специалист, студент после обучения.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Specialized {
    private String name;
    private String yearsOld;
    private String specialization;

    public String getName() {
        return this.name;
    }

    public String getYearsOld() {
        return this.yearsOld;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setYearsOld(String newYearsOld) {
        this.yearsOld = newYearsOld;
    }

    public void setSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
    }
}
