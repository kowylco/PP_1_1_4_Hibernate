package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection;

    public UserDaoJDBCImpl() {
        try {
            connection = Util.getSQLConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            String SQL = "CREATE TABLE `schema`.`test_table` (`id` INT, `name` VARCHAR(45), `lastname` VARCHAR(45), `age` INT);";

            statement.execute(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
