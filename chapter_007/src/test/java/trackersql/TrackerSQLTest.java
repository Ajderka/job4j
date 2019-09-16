package trackersql;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.09.2019.
 */
public class TrackerSQLTest {

    @Test
    public void checkConnectionInit() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenCreateNewItemThenTrue() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.deleteAll();
        Item frank = new Item("Frank", "man", 10L);
        Item met = new Item("Met", "man", 5L);
        Item ketty = new Item("Ketty", "woman", 3L);
        sql.add(frank);
        sql.add(met);
        sql.add(ketty);
        List<Item> expected = List.of(frank, met, ketty);
        assertThat(sql.findAll(), is(expected));
    }

    @Test
    public void whenCreateNewItemThenReplaceThat() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.deleteAll();
        Item bob = new Item("Bob", "man", 13L);
        Item tod = new Item("Tod", "man", 15L);
        sql.add(bob);
        sql.replace(bob.getId(), tod);
        assertThat(sql.findById(bob.getId()).getName(), is(tod.getName()));
    }

    @Test
    public void whenCreateThreeItemsThenFindName() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.deleteAll();
        Item frank = new Item("Frank", "man", 10L);
        Item met = new Item("Met", "man", 5L);
        Item ketty = new Item("Ketty", "woman", 3L);
        sql.add(frank);
        sql.add(met);
        sql.add(ketty);
        List<Item> expected = List.of(met);
        assertThat(sql.findByName(met.getName()), is(expected));
    }

    @Test
    public void whenCreateItemThenDeleteHim() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.deleteAll();
        Item result = sql.add(new Item("Item for delete", "That is bad"));
        assertTrue(sql.delete(result.getId()));

    }
}