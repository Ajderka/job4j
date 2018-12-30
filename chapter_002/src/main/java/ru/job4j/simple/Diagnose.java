package ru.job4j.simple;

/**
 * Class Diagnose - поставленный диагноз пациенту на приеме у доктора.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Diagnose {
    private String name;
    private String description;
    private String recomendation;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRecomendation() {
        return this.recomendation;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setRecomendation(String newRecomendation) {
        this.recomendation = newRecomendation;
    }

}
