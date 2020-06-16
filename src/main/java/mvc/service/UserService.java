package mvc.service;

import mvc.models.User;

import java.util.List;

public interface UserService {
        List<User> getAllUsers();

        void addUser(User user);

        void deleteUser(Long id);

        User getUserById(Long id);

        void updateUser(Long id, String name, int age, String password, String role);

        User getUserByLogin(String name, String password);
}
