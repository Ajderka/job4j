package trackersql;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenCreateNewItemThenTrue() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item Frank = new Item("Frank", "man", 10L);
        Item Met = new Item("Met", "man", 5L);
        Item Ketty = new Item("Ketty", "woman", 3L);
        sql.add(Frank);
        sql.add(Met);
        sql.add(Ketty);
        List<Item> expected = List.of(Frank, Met, Ketty);
        assertThat(sql.findAll(), is(expected));
    }
}