package trackersql;

import org.junit.Test;
import ru.job4j.tracker.Item;

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
        sql.add(new Item("Frank", "description", 123L));
        assertThat(sql.findByName("Frank").size(), is (1));
    }
}