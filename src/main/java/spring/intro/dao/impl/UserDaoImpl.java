package spring.intro.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public User get(Long id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return sessionFactory.openSession().createQuery("from User", User.class).list();
    }
}
