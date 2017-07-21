package demo.service;

import demo.util.Pagination;

import java.io.Serializable;

/**
 * Created by AnLu on
 * 2017/7/18 10:57.
 * JavaEE_Framework
 */
public interface GenericService<T extends Serializable,ID extends Number> {
    void create(T t);

    T query(String statement,Object parameter);

    Pagination<T> queryAll(int currentPage);

    Pagination<T> query(String statement,Object parameter,int currentPage);

    T queryById(ID id);

    void modify(T t);

    void modify(String statement,Object parameter);

    void remove(ID id);
}
