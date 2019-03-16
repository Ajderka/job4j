package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.03.2019.
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}