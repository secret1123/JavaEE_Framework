package demo.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/17 10:51.
 * JavaEE_Framework
 */
public interface GenericDao<T extends Serializable> {
    void create(T t);

    T query(String statement,Object parameter);

    List<T> queryAll();

    T queryById(int id);

    void modify(T t);

    void modify(String statement,Object parameter);

    void remove(int id);
}
