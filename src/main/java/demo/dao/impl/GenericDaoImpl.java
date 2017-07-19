package demo.dao.impl;

import demo.dao.GenericDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/17 11:03.
 * JavaEE_Framework
 */
public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

    private String namespace;

    @Autowired
    private SqlSession sqlSession;


    public GenericDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class clazz = (Class) parameterizedType.getActualTypeArguments()[0];
        namespace = StringUtils.uncapitalize(clazz.getSimpleName());
    }

    @Override
    public void create(T t) {
        sqlSession.insert(namespace.concat(".create"),t);
    }

    @Override
    public T query(String statement,Object parameter) {
        return sqlSession.selectOne(namespace.concat(".").concat(statement),parameter);
    }

    @Override
    public List<T> queryAll() {
        return sqlSession.selectList(namespace.concat(".queryAll"));
    }

    @Override
    public T queryById(int id) {
        return sqlSession.selectOne(namespace.concat(".queryById"),id);
    }

    @Override
    public void modify(T t) {
        sqlSession.update(namespace.concat(".modify"),t);
    }

    @Override
    public void modify(String statement, Object parameter) {
        sqlSession.update(namespace.concat(".").concat(statement),parameter);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete(namespace.concat(".remove"),id);
    }
}
