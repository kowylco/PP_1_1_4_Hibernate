package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC";
    private static final String USERNAME = "kata";
    private static final String PASSWORD = "P@ssw0rd";

    public static Connection getSQLConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
    }
}
