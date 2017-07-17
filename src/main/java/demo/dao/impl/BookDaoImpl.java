package demo.dao.impl;

import demo.dao.BookDao;
import demo.model.Book;
import org.springframework.stereotype.Repository;

/**
 * Created by AnLu on
 * 2017/7/14 11:04.
 * JavaEE_Framework
 */
@Repository
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao{
}
