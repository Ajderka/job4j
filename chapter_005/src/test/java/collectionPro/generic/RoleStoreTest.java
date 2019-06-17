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
public class RoleStoreTest {
    private RoleStore roles;

    @Before
    public void beforeAllThings() {
        roles = new RoleStore(10);
        roles.add(new Role("first"));
        roles.add(new Role("second"));
        roles.add(new Role("third"));
        roles.add(new Role("fourth"));
    }

    @Test
    public void whenAdd() {
        assertThat(roles.getIndex(2), is(roles.findById("third")));
    }

    @Test
    public void whenReplaceElement() {
        Role sub = new Role("substitute");
        roles.replace("third", sub);
        assertThat(roles.getIndex(2).getId(), is(("substitute")));
    }

    @Test
    public void whenDeleteElement() {
        assertThat(roles.delete("second"), is(true));
        assertThat(roles.getIndex(1).getId(), is("third"));
    }

    @Test
    public void whenFindItemById() {
        Role sub = new Role("third");
        assertThat(roles.findById("third").getId(), is(sub.getId()));
    }
}