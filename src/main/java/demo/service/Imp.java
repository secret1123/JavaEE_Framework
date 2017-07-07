package demo.service;

import demo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AnLu on
 * 2017/7/7 11:36.
 * JavaEE_Framework
 */
public class Imp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test/beans.xml");
        UserService userService = (UserService) context.getBean("userService");

        for (User user : userService.queryAll()){
            System.out.println(user.getUsername());
        }

//        User user = new User("new user","new password");
//        userService.createUser(user);
    }
}
