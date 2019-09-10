package storeSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.09.2019.
 */
public class StoreSQL implements AutoCloseable {

    private final Config config;
    private Connection connect = null;

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Create a new Table in the database if it does not exists.
     * Each time create a new Table to remove old items.
     */
    public void createStructure() throws SQLException {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS account");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS account ( field INTEGER )");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Generate N items in a table from 1 to n.
     *
     * @param size number of items
     * @throws SQLException if exception.
     */
    public void generate(int size) throws SQLException {
        try (Statement statement = connect.createStatement()) {
            for (int index = 1; index <= size; index++) {
                statement.executeUpdate(String.format("INSERT INTO account VALUES (%s)", index));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Loading values from table, and add us to ArrayList.
     *
     * @return ArrayList of entry loading.
     */
    public List<Entry> load() {
        List<Entry> list = new ArrayList<>();
        try {
            Statement st = this.connect.createStatement();
            st.execute("SELECT * FROM account");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                list.add(new Entry(rs.getInt(1)));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/Tools/sqlite/db/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initConnection() {
        try {
            Connection conn = DriverManager.getConnection(config.get("url"), config.get("username"), config.get("password"));
            if (conn != null) {
                this.connect = conn;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}