package demo.service;

import demo.model.User;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/4 19:38.
 * JavaEE_Framework
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public int createUser(User user) {
        return userDao.createUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }


    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User queryById(int id) {
        return userDao.queryById(id);
    }
}
