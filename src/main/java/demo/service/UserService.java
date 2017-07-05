package demo.service;

import demo.mapper.UserMapper;
import demo.model.User;
import demo.util.MyBatisSession;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by AnLu on
 * 2017/7/4 19:38.
 * JavaEE_Framework
 */
public class UserService {

    private static int createUserViaXml(){
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)){
            return sqlSession.insert("demo.mapper.UserMapper.create",new User(null,"jerry1","123"));
        }
    }

    private static int createUser(){
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.create(new User(null,"jerry2","123"));
        }
    }

    public static void main(String[] args) {
//        System.out.println(createUserViaXml());
        System.out.println(createUser());
    }
}
