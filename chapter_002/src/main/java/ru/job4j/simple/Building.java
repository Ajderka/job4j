package ru.job4j.simple;

/**
 * Class Building - построенный объект по проекту House.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.12.2018.
 */
public class Building {
    private String adress;
    private String description;

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
