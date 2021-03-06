package demo.controller;

import demo.model.Book;
import demo.service.BookService;
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

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "create")
    public String create(Book book){
        bookService.create(book);
        return "redirect:/book/queryAll";
    }

    @RequestMapping("queryAll/{currentPage}")
    private String queryAll(@PathVariable int currentPage) {
        session.setAttribute("pagination",bookService.queryAll(currentPage));
        return "redirect:/index.jsp";
    }

    @RequestMapping("queryAll")
    public String queryAll(){
        return queryAll(1);
    }

    @RequestMapping("queryById/{id}")
    public String queryById(@PathVariable int id){
        session.setAttribute("book",bookService.queryById(id));
        return "redirect:/edit.jsp";
    }

    @RequestMapping("modify")
    public String modify(Book book){
        bookService.modify(book);
        return "redirect:/book/queryAll";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable int id){
        bookService.remove(id);
        return "redirect:/book/queryAll";
    }

    @RequestMapping("removeBooks")
    private String remove(int[] ids){
        for (int id : ids) {
            bookService.remove(id);
        }
        return "redirect:/book/queryAll";
    }
}
