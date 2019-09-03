package SQL;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import principle004.UsageLog4j2;

import java.sql.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.09.2019.
 */
public class SQLStorage {
    private static final Logger Log = LogManager.getLogger(UsageLog4j2.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/car";
        String username = "postgres";
        String password = "1402";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM car");
            while (rs.next())
            {
                System.out.println(String.format("%s %s", rs.getInt("car_engine_id"), rs.getInt("car_body_id")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
    }
}
