package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 12.03.2019.
 */
public class UserConvertTest {

    @Test
    public void whenListOfTwoArraysThenConvertToOneList() {
        UserConvert converter = new UserConvert();

        List<User> users = Arrays.asList(
                new User(1, "Ayder", "Netheshin"),
                new User(2, "Anatoliy", "Kiev"),
                new User(3, "Dima", "Moscow")
        );

        Map<Integer, User> result = converter.process(users);
        assertThat(result.get(2).getName(), is("Anatoliy"));
    }
}
