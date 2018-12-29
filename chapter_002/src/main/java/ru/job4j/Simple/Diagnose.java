package ru.job4j.Simple;

public class Diagnose {
    public String name;
    public String description;
    public String recomendation;

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
