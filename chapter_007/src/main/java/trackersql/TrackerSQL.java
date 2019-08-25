package trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    /**
     * Method that loading the driver and connecting to the database.
     *
     * @return true if connection is open.
     */
    boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            assert in != null;
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Add item to List.
     *
     * @param item input object of class item.
     */
    @Override
    public Item add(Item item) {
        String insertItem = "INSERT INTO tracker (name, description, create) VALUES (?,?,?)";
        try (final PreparedStatement st = this.connection.prepareStatement(insertItem, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, new Timestamp(item.getCreate()));
            st.executeUpdate();
            try (ResultSet resultSetGenKeys = st.getGeneratedKeys()) {
                if (resultSetGenKeys.next()) {
                    item.setId((resultSetGenKeys.getString(1)));
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return item;
    }

    /**
     * Changes the item in the List by the id.
     *
     * @param id   input id.
     * @param item input Item.
     * @return boolean result process.
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (final PreparedStatement st = this.connection.prepareStatement(
                "UPDATE tracker SET name = ?, description = ?, create = ? WHERE id = ?"
        )) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, new Timestamp(item.getCreate()));
            st.setInt(4, Integer.valueOf(id));
            int rows = st.executeUpdate();
            result = (rows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Delete the item in the List by id.
     *
     * @param id input id.
     * @return boolean result process.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (final PreparedStatement st = this.connection.prepareStatement(
                "DELETE FROM tracker WHERE id = ?"
        )) {
            st.setInt(1, Integer.valueOf(id));
            int rows = st.executeUpdate();
            result = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method that returns all element.
     *
     * @return list with all element.
     */
    @Override
    public List<Item> findAll() {
        List<Item> listOfNames = new ArrayList<>();
        try (final PreparedStatement st = this.connection.prepareStatement("SELECT * FROM tracker");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                listOfNames.add(new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("create")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfNames;
    }

    /**
     * Method that returns item by name.
     *
     * @param key item.
     * @return list with finding item.
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> listOfItemsByName = new ArrayList<>();
        try (final PreparedStatement st = this.connection.prepareStatement("SELECT * FROM tracker WHERE name = ?");
             ResultSet rs = st.executeQuery()) {
            st.setString(1, key);
            while (rs.next()) {
                listOfItemsByName.add(new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("create")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfItemsByName;
    }

    /**
     * Method that returns item by id.
     *
     * @param id item.
     * @return item finding by id.
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        try (final PreparedStatement st = this.connection.prepareStatement("SELECT * FROM  tracker WHERE id = ?");
             ResultSet rs = st.executeQuery()) {
            st.setInt(1, Integer.valueOf(id));
            while (rs.next()) {
                result = new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("create"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}