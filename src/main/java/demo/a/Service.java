package demo.a;

/**
 * Created by AnLu on
 * 2017/7/6 09:43.
 * JavaEE_Framework
 */
public class Service {
    public static void main(String[] args) {
        Business business = new Business(new FloppyWriter());
        business.write();
    }
}
