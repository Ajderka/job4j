/*
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParsersTest {

    @Test
    public void whenAddNewVacancyThanTrue() throws SQLException {
        try (Parsers parsers = new Parsers(ConnectionRollback.create(this.init()))) {
            assertTrue(parsers.);
        }
    }

    public Connection init() {
        try (InputStream in = Parsers.class.getClassLoader().getResourceAsStream("app.properties")) {
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

    public static class ConnectionRollback {
        */
/**
         * Create connection with autocommit=false mode and rollback call, when connection is closed.
         * @param connection connection.
         * @return Connection object.
         * @throws SQLException possible exception.
         *//*

        public static Connection create(Connection connection) throws SQLException {
            connection.setAutoCommit(false);
            return (Connection) Proxy.newProxyInstance(
                    ConnectionRollback.class.getClassLoader(),
                    new Class[] {Connection.class },
                    (proxy, method, args) -> {
                        Object rsl = null;
                        if ("close".equals(method.getName())) {
                            connection.rollback();
                            connection.close();
                        } else {
                            rsl = method.invoke(connection, args);
                        }
                        return rsl;
                    }
            );
        }
    }
}*/
