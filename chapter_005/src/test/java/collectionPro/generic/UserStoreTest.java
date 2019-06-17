package collectionPro.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.06.2019.
 */
public class UserStoreTest {
    private UserStore userStore;

    @Before
    public void beforeAllThings() {
        userStore = new UserStore(10);
        userStore.add(new User("first"));
        userStore.add(new User("second"));
        userStore.add(new User("third"));
        userStore.add(new User("fourth"));
    }

    @Test
    public void whenAdd() {
        assertThat(userStore.getIndex(2), is(userStore.findById("third")));
    }

    @Test
    public void whenReplaceElement() {
        User sub = new User("substitute");
        userStore.replace("third", sub);
        assertThat(userStore.getIndex(2).getId(), is(("substitute")));
    }

    @Test
    public void whenDeleteElement() {
        assertThat(userStore.delete("second"), is(true));
        assertThat(userStore.getIndex(1).getId(), is("third"));
    }

    @Test
    public void whenFindItemById() {
        User sub = new User("third");
        assertThat(userStore.findById("third").getId(), is(sub.getId()));
    }
}