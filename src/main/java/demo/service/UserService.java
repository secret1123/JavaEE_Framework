package demo.service;

import demo.mapper.UserMapper;
import demo.model.User;
import demo.util.MyBatisSession;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/4 19:38.
 * JavaEE_Framework
 */
public class UserService {

    private static int deleteUser(){
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(true)){
            return sqlSession.delete("demo.mapper.UserMapper.delete",new User(5));
        }
    }

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

    private static List<User> queryAll(){
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)){
            return sqlSession.selectList("demo.mapper.UserMapper.queryAll");
        }
    }

    private static User queryById(){
        try(SqlSession sqlSession = MyBatisSession.getSqlSession(false)){
            return sqlSession.selectOne("user.queryById",new User(3));
        }
    }

    public static void main(String[] args) {
        System.out.println(queryById());
//        System.out.println(deleteUser());
//        System.out.println(createUserViaXml());
//        System.out.println(createUser());
//        List<User> users = queryAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
    }
}
