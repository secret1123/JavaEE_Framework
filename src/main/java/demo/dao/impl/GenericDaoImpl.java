package demo.dao.impl;

import demo.dao.GenericDao;
import demo.util.Constant;
import demo.util.Pagination;
import org.apache.ibatis.session.RowBounds;
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
public class GenericDaoImpl<T extends Serializable,ID extends Number> implements GenericDao<T,ID> {

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
    public Pagination<T> queryAll(int currentPage) {
        return getPagination("queryAll",null,currentPage);
    }

    @Override
    public Pagination<T> query(String statement,Object parameter,int currentPage) {
        return getPagination(statement,parameter,currentPage);
    }


    @Override
    public T queryById(ID id) {
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
    public void remove(ID id) {
        sqlSession.delete(namespace.concat(".remove"),id);
    }

    /**
     * 分页查询
     *
     * @param statement 查询SQL的id
     * @param parameter 查询的参数
     * @param currentPage 当前页
     * @return Pagination 的实例
     */
    private Pagination<T> getPagination(String statement, Object parameter, int currentPage) {
        int totalRows = sqlSession.selectList(namespace.concat(".").concat(statement),parameter).size();
        int totalPages = (int) Math.ceil(totalRows / (double) Constant.PAGE_SIZE);
        RowBounds rowBounds = new RowBounds((currentPage - 1) * Constant.PAGE_SIZE,Constant.PAGE_SIZE);
        List<T> list = sqlSession.selectList(namespace.concat(".").concat(statement),parameter,rowBounds);
        return new Pagination<>(list,statement,Constant.PAGE_SIZE,totalRows,totalPages,currentPage);
    }
}

