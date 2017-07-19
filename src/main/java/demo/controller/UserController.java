package demo.controller;

import demo.model.User;
import demo.service.UserService;
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
    private UserService userService;

    @RequestMapping("signUp")
    public String signUp(User user) {
        if (userService.signUp(user)) {
            return "redirect:/default.jsp";
        }
        request.setAttribute("message","用户名已经存在");
        return "/sign_up.jsp";
    }

    @RequestMapping("signIn")
    public String signIn(User user) {
        user = userService.signIn(user);
        if (user != null) {
                session.setAttribute("user", user);
                return "redirect:/book/queryAll";
            }
        request.setAttribute("message", "用户名或密码错误");
        return "/default.jsp";
    }

    @RequestMapping("signOut")
    public String signOut() {
        session.invalidate();
        return "redirect:/default.jsp";
    }
}
