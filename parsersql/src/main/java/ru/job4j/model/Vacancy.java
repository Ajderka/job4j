package ru.job4j.model;

import java.util.Date;
import java.util.Objects;

public class Vacancy {
    private int id;
    private String name;
    private String text;
    private String link;
    private Date date;

    public Vacancy(String name, String text, String link, Date date) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public Date getDate() {
        return date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
       return String.format("Vacancy id: %s. Title: %s. URL: %s. Text: %s. Date: %s", id, name, link, text, date);
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
}
