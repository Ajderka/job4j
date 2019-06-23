package ru.job4j.collectionpro.generic;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.06.2019.
 */
public class Role extends Base {
    protected Role(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Role{ %s }", getId());
    }
}
