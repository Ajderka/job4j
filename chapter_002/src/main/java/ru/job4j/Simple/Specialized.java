package ru.job4j.Simple;

public class Specialized {
    public String name;
    public String yearsOld;
    public String specialization;

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
