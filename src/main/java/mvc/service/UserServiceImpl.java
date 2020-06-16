package mvc.service;

import mvc.dao.UserDAO;
import mvc.dao.UserDAOImpl;
import mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAOImpl userDAO;

    @Transactional
    @Override
    public User getUserById(Long id) {
        User user = null;

        if (id != null) {
            user = userDAO.getUserById(id);
        }
        return user;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void updateUser(Long id, String name, int age, String password, String role) {
        if (name.isEmpty() && password.isEmpty()) {
            return;
        }
        userDAO.updateUser(id, name, age, password, role);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        if (!user.getName().isEmpty() || !user.getPassword().isEmpty()) {
            userDAO.addUser(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        if (id != null) {
            userDAO.deleteUser(id);
        }
    }

    @Transactional
    @Override
    public User getUserByLogin(String name, String password) {
        return userDAO.getUserByLogin(name, password);
    }

}
