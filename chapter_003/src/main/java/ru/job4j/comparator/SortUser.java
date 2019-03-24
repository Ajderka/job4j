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
     * Метод сортирует список users по годам.
     *
     * @param users входящий неотсортированный список users.
     * @return сортированный список users.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Метод сортирует список по количеству символов в имени.
     *
     * @param users входящий не отсортированный список users.
     * @return сортированный список users.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int val = o1.getLengthName().compareTo(o2.getLengthName());
                return val;
            }
        });
        return users;
    }

    /**
     * Метод сортирует список по имени и годам.
     *
     * @param users входящий не отсортированный список users.
     * @return сортированный список users.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = Integer.compare(o1.getAge(), o2.getAge());
                }
                return result;
            }
        });
        return users;
    }
}