package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSQLConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = getSQLConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS `users` (`id` SERIAL, `name` VARCHAR(45), `lastname` VARCHAR(45), `age` INT);");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = getSQLConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement prepareStatement = getSQLConnection().prepareStatement("insert into users (name, lastname, age) values (?, ?, ?);")) {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, lastName);
            prepareStatement.setByte(3, age);

            prepareStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = getSQLConnection().prepareStatement("DELETE FROM users WHERE id=?;")) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = getSQLConnection().prepareStatement("SELECT all * FROM users;").executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                byte age = resultSet.getByte("age");

                User user = new User(name, lastname, age);
                user.setId(id);
                users.add(user);
            }

            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = getSQLConnection().prepareStatement("TRUNCATE users")) {
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}