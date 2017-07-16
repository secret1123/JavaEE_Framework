package demo.dao.impl;

import demo.dao.UserDao;
import demo.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by AnLu on
 * 2017/7/11 14:18.
 * JavaEE_Framework
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void create(User user) {
        sqlSession.insert("user.create", user);
    }

    @Override
    public User signIn(User user) {
        return sqlSession.selectOne("user.signIn", user);
    }
}
