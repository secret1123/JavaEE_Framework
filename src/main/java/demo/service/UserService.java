package demo.service;

import demo.model.User;

/**
 * Created by AnLu on
 * 2017/7/18 10:57.
 * JavaEE_Framework
 */
public interface UserService extends GenericService<User,Integer>{
    User signIn(User user);

    boolean signUp(User user);
}
