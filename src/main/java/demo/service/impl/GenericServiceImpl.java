package demo.service.impl;

import demo.dao.GenericDao;
import demo.service.GenericService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/18 11:01.
 * JavaEE_Framework
 */
public abstract class GenericServiceImpl<T extends Serializable,ID extends Number> implements GenericService<T,ID> {

    GenericDao<T,ID> genericDao;

    public abstract void setGenericDao(GenericDao<T,ID> genericDao);
    @Override
    public void create(T t) {
        genericDao.create(t);
    }

    @Override
    public T query(String statement, Object parameter) {
        return genericDao.query(statement, parameter);
    }

    @Override
    public List<T> queryAll() {
        return genericDao.queryAll();
    }

    @Override
    public List<T> list(int page){
        return null;
    }

    @Override
    public T queryById(ID id) {
        return genericDao.queryById(id);
    }

    @Override
    public void modify(T t) {
        genericDao.modify(t);
    }

    @Override
    public void modify(String statement, Object parameter) {
        genericDao.modify(statement, parameter);
    }

    @Override
    public void remove(ID id) {
        genericDao.remove(id);
    }
}
