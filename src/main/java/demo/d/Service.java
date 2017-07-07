package demo.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AnLu on
 * 2017/7/6 11:41.
 * JavaEE_Framework
 */
public class Service {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) applicationContext.getBean("hello");
        hello.sayHello();
    }
}
