package ru.job4j.collectionpro.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 05.07.2019.
 */
public class UserTest {

    @Test
    public void whenAddTwoUsers() {
        Map<User, Object> map = new HashMap<>();
        User first = new User("Ivan", 0, new GregorianCalendar(1987, 2, 14));
        User second = new User("Ivan", 0, new GregorianCalendar(1987, 2, 14));
        map.put(first, "one");
        map.put(second, "two");
        System.out.println(map);
    }
}