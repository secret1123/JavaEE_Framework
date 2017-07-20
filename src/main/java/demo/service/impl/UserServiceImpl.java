package demo.service.impl;

import demo.dao.GenericDao;
import demo.model.User;
import demo.service.UserService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by AnLu on
 * 2017/7/18 11:01.
 * JavaEE_Framework
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User,Integer> implements UserService{

    @Autowired
    private StrongPasswordEncryptor encryptor;

    @Override
    @Autowired
    @Qualifier("userDaoImpl")
    public void setGenericDao(GenericDao<User,Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public User signIn(User user) {
        String plainPassword = user.getPassword();
        user = genericDao.query("queryByUsername",user.getUsername());
        if (user != null) {
            String encryptedPassword = user.getPassword();
            if (encryptor.checkPassword(plainPassword,encryptedPassword)) {
                genericDao.modify("updateLastTime",user.getId());
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean signUp(User user) {
        if (genericDao.query("queryByUsername",user.getUsername()) == null) {
            user.setPassword(encryptor.encryptPassword(user.getPassword()));
            genericDao.create(user);
            return true;
        }
        return false;
    }
}
