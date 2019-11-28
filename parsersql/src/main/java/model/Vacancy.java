package model;

import java.util.Objects;

public class Vacancy {
    private int id;
    private String name;
    private String text;
    private String link;

    public Vacancy(String link,  String name) {
        this.name = name;
        this.link = link;
    }

    public Vacancy(String title, String text, String url) {
        this.name = title;
        this.text = text;
        this.link = url;
    }

    public Vacancy(int id, String name, String text, String link) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.link = link;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
       return String.format("model.Vacancy id: %s. Title: %s. URL: %s. Text: %s", id, name, link, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id &&
                Objects.equals(name, vacancy.name) &&
                Objects.equals(text, vacancy.text) &&
                Objects.equals(link, vacancy.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, link);
    }
}
