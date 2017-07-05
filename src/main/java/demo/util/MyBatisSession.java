package demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by AnLu on
 * 2017/7/4 19:40.
 * JavaEE_Framework
 */
public class MyBatisSession {
    private static SqlSessionFactory sqlSessionFactory;

    private static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
                try {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sqlSessionFactory;
        }
        public static SqlSession getSqlSession(boolean autoCommit){
        return getSqlSessionFactory().openSession(autoCommit);
    }
}
