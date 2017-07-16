package demo.dao.impl;

import demo.dao.BookDao;
import demo.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/14 11:04.
 * JavaEE_Framework
 */
@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void create(Book book) {
        sqlSession.insert("book.create",book);
    }

    @Override
    public List<Book> queryAll() {
        return sqlSession.selectList("book.queryAll");
    }

    @Override
    public Book queryBookById(int id) {
        return sqlSession.selectOne("book.queryBookById",id);
    }

    @Override
    public void modify(Book book) {
        sqlSession.update("book.modify",book);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete("book.remove",id);
    }
}
