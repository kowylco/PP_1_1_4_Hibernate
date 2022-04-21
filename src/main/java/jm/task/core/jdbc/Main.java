package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

//1 Создание таблицы User(ов)
        userService.createUsersTable();
//2 Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль
        userService.saveUser("Vasya", "Lozhkin", (byte) 23);
        userService.saveUser("Petya", "Vilkin", (byte) 34);
        userService.saveUser("Zosya", "Golubikovaya", (byte) 24);
        userService.saveUser("Ernest", "Goloveshkin", (byte) 56);
//3 Получение всех User из базы и вывод в консоль
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
//4 Очистка таблицы User(ов)
        userService.cleanUsersTable();
//5 Удаление таблицы
        userService.dropUsersTable();
    }
}
