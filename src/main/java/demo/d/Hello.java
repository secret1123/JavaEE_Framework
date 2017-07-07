package demo.d;

/**
 * Created by AnLu on
 * 2017/7/6 11:39.
 * JavaEE_Framework
 */
public class Hello {
//    private String(chaSequence 接口的实现类) name;

    private CharSequence name;//接口

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    public void setName(CharSequence name){
        this.name = name;
    }
}
