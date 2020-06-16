package mvc.dao;

import mvc.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    void updateUser(Long id, String name, int age, String password, String role);

    User getUserByLogin(String name, String password);
}
