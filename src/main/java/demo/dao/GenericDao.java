package demo.dao;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/17 10:51.
 * JavaEE_Framework
 */
public interface GenericDao<T> {
    void create(T t);

    T query(T t);

    List<T> queryAll();

    T queryById(int id);

    void modify(T t);

    void remove(int id);
}
