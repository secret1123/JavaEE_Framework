package demo.dao.impl;

import demo.dao.UserDao;
import demo.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by AnLu on
 * 2017/7/11 14:18.
 * JavaEE_Framework
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao{
}
