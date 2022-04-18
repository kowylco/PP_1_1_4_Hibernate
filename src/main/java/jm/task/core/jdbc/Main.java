package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.createUsersTable();

        userDao.saveUser("Aasya", "Pukin", (byte) 23);
        userDao.saveUser("Xasya", "Pukin", (byte) 34);
        userDao.saveUser("FEsya", "Pukin", (byte) 24);

        userDao.removeUserById(1);

        List<User> users = userDao.getAllUsers();
        users.forEach(System.out::println);

        System.out.println("after clean");
        userDao.cleanUsersTable();
        users = userDao.getAllUsers();
        users.forEach(System.out::println);


        userDao.dropUsersTable();
        userDao.dropUsersTable();
    }
}
