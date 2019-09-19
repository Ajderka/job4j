package trackersql;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 19.09.2019.
 */
public class TrackerSQLTest {

    private Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkConnectionInit() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.init(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreateNewItemThenTrue() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            tracker.deleteAll();
            Item frank = new Item("Frank", "man", 10L);
            Item met = new Item("Met", "man", 5L);
            Item ketty = new Item("Ketty", "woman", 3L);
            tracker.add(frank);
            tracker.add(met);
            tracker.add(ketty);
            List<Item> expected = List.of(frank, met, ketty);
            assertThat(tracker.findAll(), is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreateNewItemThenReplaceThat() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            tracker.deleteAll();
            Item bob = new Item("Bob", "man", 13L);
            Item tod = new Item("Tod", "man", 15L);
            tracker.add(bob);
            tracker.replace(bob.getId(), tod);
            assertThat(tracker.findById(bob.getId()).getName(), is(tod.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreateThreeItemsThenFindName() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            tracker.deleteAll();
            Item frank = new Item("Frank", "man", 10L);
            Item met = new Item("Met", "man", 5L);
            Item ketty = new Item("Ketty", "woman", 3L);
            tracker.add(frank);
            tracker.add(met);
            tracker.add(ketty);
            List<Item> expected = List.of(met);
            assertThat(tracker.findByName(met.getName()), is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreateItemThenDeleteHim() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.init();
            tracker.deleteAll();
            Item result = tracker.add(new Item("Item for delete", "That is bad"));
            assertTrue(tracker.delete(result.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}