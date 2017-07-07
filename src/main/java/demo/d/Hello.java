package demo.d;

/**
 * Created by AnLu on
 * 2017/7/6 11:39.
 * JavaEE_Framework
 */
public class Hello {
    private String name;

    public void sayHello() {

        System.out.println("Hello, " + name);
    }

    public void setName(String name){
        name = "Tom";
        this.name = name;
    }
}
