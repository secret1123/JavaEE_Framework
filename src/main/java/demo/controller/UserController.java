package demo.controller;

import demo.dao.UserDao;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AnLu on
 * 2017/7/10 16:43.
 * JavaEE_Framework
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("create")
    public String create(User user) {
        userDao.create(user);
        return "redirect:/default.jsp";
    }

    @RequestMapping("query")
    public String query(User user) {
        user = userDao.query(user);
        if (user != null) {
            session.setAttribute("user",user);
            return "redirect:/book/queryAll";
        }
        request.setAttribute("message","用户名或密码错误");
        return "/default.jsp";
    }

    @RequestMapping("signOut")
    public String signOut(){
        session.invalidate();
        return "redirect:/default.jsp";
    }
}
