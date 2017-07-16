package demo.dao;

import demo.model.User;

/**
 * Created by AnLu on
 * 2017/7/10 19:21.
 * JavaEE_Framework
 */
public interface UserDao {
    void create(User user);

    User signIn(User user);
}