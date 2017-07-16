package demo.controller;

import demo.dao.BookDao;
import demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AnLu on
 * 2017/7/14 11:10.
 * JavaEE_Framework
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping("create")
    public String create(Book book){
        bookDao.create(book);
        return "redirect:/book/queryAll";
    }

    @RequestMapping("queryAll")
    public String queryAll(){
        session.setAttribute("books",bookDao.queryAll());
        return "redirect:/index.jsp";
    }

    @RequestMapping("queryBookById/{id}")
    public String queryBookById(@PathVariable int id){
        session.setAttribute("book",bookDao.queryBookById(id));
        return "redirect:/edit.jsp";
    }

    @RequestMapping("modify")
    public String modify(Book book){
        bookDao.modify(book);
        return "redirect:/book/queryAll";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable int id){
        bookDao.remove(id);
        return "redirect:/book/queryAll";
    }
}
