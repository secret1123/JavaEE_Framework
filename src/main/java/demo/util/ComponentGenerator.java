package demo.util;

import freemarker.template.Template;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AnLu on
 * 2017/7/19 20:41.
 * JavaEE_Framework
 */
class ComponentGenerator {

    private static final String PACKAGE = "demo";
    private static final String DATABASE = "db_test";
    private static final String CODE_PATH = "src/main/java/";
    private static final String PAGE_PATH = "src/main/webapp/";
    private static final String CONF_PATH = "src/main/resources/";
    private static final String PATH = CODE_PATH + PACKAGE.replace(".","/");
    private static final String[] CODE_TPLS = {"Model","Dao","Dao.Impl","Service","Service.Impl","Controller.ftl"};
    private static final String[] PAGE_TPLS = {"index","add","list","edit"};
    private static final String[] CONF_TPLS = {"mapper"};

    private static String pk;
    private static String model;
    private static String properties;
    private static Scanner scanner = new Scanner(System.in);
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("freemarker.xml");

    public static void main(String[] args) throws Exception{
        input();
        for (String tpl : CODE_TPLS) {
            generate(tpl,"code");
        }
        for (String tpl : CONF_TPLS) {
            generate(tpl,"conf");
        }
        System.out.println("generate pages?(y/n)");
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")){
            for (String tpl : PAGE_TPLS) {
                generate(tpl,"page");
            }
        }
        System.out.println("done.");
    }

    private static void input() {
        System.out.println("input model class name,e.g:Person:");
        model = scanner.nextLine();
        System.out.println("input primary key type,e.g:Integer:");
        pk = scanner.nextLine();
        System.out.println("input properties,e.g:String name, :");
        properties = scanner.nextLine();
    }

    private static void generate(String tpl, String type) throws Exception {
        Map<String,String> propertyMap = new LinkedHashMap<>();
        Map<String,String> columnMap = new LinkedHashMap<>();
        for (String kv : properties.split(",")) {
            String[] strings = kv.split(" ");
            propertyMap.put(strings[1],strings[0]);
            columnMap.put(strings[1],strings[1]);
        }

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("properties",propertyMap);
        map.put("package",PACKAGE);
        map.put("model",model);
        map.put("pk",pk);
        map.put("db",DATABASE);
        map.put("table",convertJavaNameToDatabaseName(model));
        map.put("columns",columnMap);

        File file = null;
        String name = null;
        switch (type){
            case"page":{
                File path = new File(PAGE_PATH + model.toLowerCase());
                if (!path.exists()){
                    System.out.println("make page directories..." + path.mkdir());
                }
                file = new File(path + "/" + tpl + ".jsp");
                name = "page/" + tpl + ".ftl";
                break;
            }
            case "code":
                file = new File(PATH + "/" + tpl.toLowerCase().replace('.','/') + "/" +model + tpl.replace(".","") + ".java");
                if (tpl.equals("Model")){
                    file = new File(PATH + "/model/" + model + ".java");
                }
                name = "code/" + tpl + ".ftl";
                break;
            case "conf":{
                File path = new File(CONF_PATH + "mapper");
                if (!path.exists()){
                    System.out.println("make conf directories..." + path.mkdir());
                }
                file = new File(path + "/" + convertJavaNameToDatabaseName(model) + "-mapper" + ".xml");
                name = "conf/" + tpl + ".ftl";
                break;
            }
            default:
                break;
        }
        Writer writer = null;
        if (file != null) {
            writer = new FileWriter(file);
        }
        FreeMarkerConfig freeMarkerConfig = applicationContext.getBean(FreeMarkerConfigurer.class);
        System.out.println("name:" + name);
        Template template = freeMarkerConfig.getConfiguration().getTemplate(name);
        template.process(map,writer);
        if (writer != null) {
            writer.close();
        }
        System.out.println("\t" + file + "\t generated!");
    }

    private static String convertJavaNameToDatabaseName(String ClassName) {
        Pattern pattern = Pattern.compile("(?!^)[A-Z]");
        Matcher matcher = pattern.matcher(ClassName);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group().toLowerCase());
            if (!matcher.hitEnd()){
                stringBuilder.append("_");
            }
        }
        return stringBuilder.toString();
    }
}
