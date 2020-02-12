package spring.intro.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
