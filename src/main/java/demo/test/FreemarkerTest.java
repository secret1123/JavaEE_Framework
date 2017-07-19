package demo.test;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AnLu on
 * 2017/7/19 10:07.
 * JavaEE_Framework
 */
public class FreemarkerTest {
    public static void main(String[] args) throws IOException,TemplateException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FreeMarkerConfig freeMarkerConfig = (FreeMarkerConfig) applicationContext.getBean("freemarker");

        String model = "Student";

        Template template = freeMarkerConfig.getConfiguration().getTemplate("dao.ftl");
        Map<String,String> map = new HashMap<>();
        map.put("model",model);
        Writer writer = new FileWriter("src/main/java/demo/dao/"+model+"Dao.java");
        template.process(map,writer);
    }
}
