package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

//1 Создание таблицы User(ов)
        userDao.createUsersTable();
//2 Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль
        userDao.saveUser("Vasya", "Lozhkin", (byte) 23);
        userDao.saveUser("Petya", "Vilkin", (byte) 34);
        userDao.saveUser("Zosya", "Golubikovaya", (byte) 24);
        userDao.saveUser("Ernest", "Goloveshkin", (byte) 56);
//3 Получение всех User из базы и вывод в консоль
        List<User> users = userDao.getAllUsers();
        users.forEach(System.out::println);
//4 Очистка таблицы User(ов)
        userDao.cleanUsersTable();
//5 Удаление таблицы
        userDao.dropUsersTable();
    }
}
