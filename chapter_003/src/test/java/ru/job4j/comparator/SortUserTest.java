package ru.job4j.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.03.2019.
 */
public class SortUserTest {

    @Test
    public void whenSortNameLength() {
        SortUser user = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Айдер", 25));
        users.add(new User("Иван", 30));
        users.add(new User("Сергей", 20));
        users.add(new User("Игнатий", 25));

        List<User> expected = new ArrayList<>();
        expected.add(users.get(1));
        expected.add(users.get(0));
        expected.add(users.get(2));
        expected.add(users.get(3));

        assertThat(user.sortNameLength(users), is(expected));
    }

    @Test
    public void whenSortByAllFields() {
        SortUser user = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Сергей", 25));
        users.add(new User("Иван", 30));
        users.add(new User("Сергей", 20));
        users.add(new User("Иван", 25));

        List<User> expected = new ArrayList<>();
        expected.add(users.get(3));
        expected.add(users.get(1));
        expected.add(users.get(2));
        expected.add(users.get(0));

        assertThat(user.sortByAllFields(users), is(expected));
    }
}