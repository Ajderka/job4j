package ru.job4j.Simple;

public class Building {
    public String adress;
    public String description;

    public String getAdress() {
        return this.adress;
    }

    public String getDescription() {
        return this.description;
    }

    public void setAdress(String newName) {
        this.adress = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
}
