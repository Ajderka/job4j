package ru.job4j.sort;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.03.2019.
 */
public class SortUserTest {

    @Test
    public void whenAddUserInTreeSet() {
        SortUser user = new SortUser();

        var users = List.of(
                new User("Ajderka", 37),
                new User("Ivanka", 33),
                new User("Kostya", 35)
        );

        var expected = Set.of(
                new User("Ivanka", 33),
                new User("Kostya", 35),
                new User("Ajderka", 37)
        );
        assertThat(user.sort(users), is(expected));
    }
}