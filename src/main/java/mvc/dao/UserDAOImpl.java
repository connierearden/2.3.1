package mvc.dao;

import mvc.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
        return list;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        /*Query query = sessionFactory.getCurrentSession().createQuery("delete from User u where u.id = :id");
        query.setParameter("id", id);*/
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public void updateUser(Long id, String name, int age, String password, String role) {
        Query query = sessionFactory.getCurrentSession()
                                    .createQuery("update User u set  u.name = :name, u.age = :age, u.password = :password, u.role = :role  where u.id = :id");
        query.setParameter("name", name);
        query.setParameter("age", age);
        query.setParameter("password", password);
        query.setParameter("role", role);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public User getUserByLogin(String name, String password) {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.name = :name and u.password = :pass");
            query.setParameter("name", name);
            query.setParameter("pass", password);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
