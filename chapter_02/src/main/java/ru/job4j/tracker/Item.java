package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class  Item.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.01.2019.
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long create;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String id, String name, String description, long create) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public long getCreate() {
        return create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return create == item.create
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description)
                && Arrays.equals(comments, item.comments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, description, create);
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }

    @Override
    public String toString() {
        return " Id: " + this.getId() + "\n"
                + " Name : " + this.getName() + "\n"
                + " Description : " + this.getDescription() + "\n"
                + " Create : " + this.getCreate();
    }
}
