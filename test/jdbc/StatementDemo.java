package ru.job4j;

import java.sql.*;


public class StatementDemo {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/tracker";
    static final String USER = "postgres";
    static final String PASSWORD = "1402";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        Statement statement;

        System.out.println("Register JDBC Driver");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Creating statement...");
        statement = connection.createStatement();

        String sql = "SELECT * FROM vacancies";

        Boolean isRetrieved = statement.execute(sql);

        System.out.println("Is data retrieved: " + isRetrieved);

        System.out.println("Displaying retrieved data:");
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String link = resultSet.getString("link");

            System.out.println("Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Link: " + link);
        }

        System.out.println("Closing connection and releasing resources...");

        try {
            resultSet.close();
            statement.close();
            connection.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        System.out.println("is it all, thx you");
    }
}