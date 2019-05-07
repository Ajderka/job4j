package ru.job4j.comparator;

import java.util.Comparator;
import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.03.2019.
 */
public class SortUser {

    /**
     * Метод сортирует список по количеству символов в имени.
     *
     * @param users входящий не отсортированный список users.
     * @return сортированный список users.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(Comparator.comparing(User::getLengthName));
        return users;
    }

    /**
     * Метод сортирует список по имени и годам.
     *
     * @param users входящий не отсортированный список users.
     * @return сортированный список users.
     */
    public List<User> sortByAllFields(List<User> users) {
       users.sort(Comparator.comparing(User::getName).thenComparingInt(User::getAge));
       return users;
    }
}