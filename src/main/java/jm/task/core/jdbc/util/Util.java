package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/schema?serverTimezone=UTC";
    private static final String USERNAME = "kata";
    private static final String PASSWORD = "P@ssw0rd";

    private Util() {

    }

    public static synchronized Connection getSQLConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}