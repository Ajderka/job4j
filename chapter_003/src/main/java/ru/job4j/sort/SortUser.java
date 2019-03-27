package ru.job4j.sort;


import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.03.2019.
 */
public class SortUser {

    /**
     * Метод сортирует список users по годам.
     *
     * @param users входящий неотсортированный список users.
     * @return сортированный список users.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }
}