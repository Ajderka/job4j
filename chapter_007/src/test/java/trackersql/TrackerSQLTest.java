package trackersql;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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
        Item Frank = new Item("Frank", "man", 10L);
        Item Met = new Item("Met", "man", 5L);
        Item Ketty = new Item("Ketty", "woman", 3L);
        sql.add(Frank);
        sql.add(Met);
        sql.add(Ketty);
        List<Item> expected = List.of(Frank, Met, Ketty);
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
        Item Frank = new Item("Frank", "man", 10L);
        Item Met = new Item("Met", "man", 5L);
        Item Ketty = new Item("Ketty", "woman", 3L);
        sql.add(Frank);
        sql.add(Met);
        sql.add(Ketty);
        List<Item> expected = List.of(Met);
        assertThat(sql.findByName(Met.getName()), is(expected));
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