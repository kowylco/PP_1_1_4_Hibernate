package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Connection connection;
    static {
        try {
            connection = Util.getSQLConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String SQL = "CREATE TABLE IF NOT EXISTS `users` (`id` SERIAL, `name` VARCHAR(45), `lastname` VARCHAR(45), `age` INT);";

            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String SQL = "DROP TABLE IF EXISTS users";

            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            String SQL = String.format("insert into users (name, lastname, age) values ('%s', '%s', '%d');", name, lastName, age);

            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            String SQL = String.format("DELETE FROM users WHERE id='%d';", id);

            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        Statement statement = null;
        List<User> users = new ArrayList<>();

        try {
            statement = connection.createStatement();
            String SQL = "select all * from users;";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                byte age = resultSet.getByte("age");

                User user = new User(name, lastname, age);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                //ignore
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String SQL = "truncate users";

            statement.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
