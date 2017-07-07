package demo.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AnLu on
 * 2017/7/6 11:04.
 * JavaEE_Framework
 */
public class Service {
    public static void main(String[] args) {
//        Business business = new Business();
//        business.setDeviceWriter(new UsbWriter());
//        business.write();

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Business business = (Business) applicationContext.getBean("business");
    business.write();
    }

}
