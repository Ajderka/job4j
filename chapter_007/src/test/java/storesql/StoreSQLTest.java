package storesql;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 04.09.2019.
 */
public class StoreSQLTest {

    @Test
    public void whenAddTenElementsAndSelectThanTrue() throws Exception {
        Config config = new Config();
        config.init();
        StoreSQL store = new StoreSQL(config);
        store.initConnection();
        store.createStructure();
        try {
            store.generate(100);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Entry> list = store.load();
        store.close();
        List<Entry> expected = Stream.iterate(1, n -> n + 1).limit(100).map(Entry::new).collect(Collectors.toList());
        assertThat(list, is(expected));
    }
}