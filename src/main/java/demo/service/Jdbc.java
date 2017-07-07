package demo.service;

import demo.model.User;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/7 10:54.
 * JavaEE_Framework
 */
public class Jdbc implements UserDao {

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public User queryById(int id) {
        return null;
    }
}
