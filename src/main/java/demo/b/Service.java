package demo.b;

/**
 * Created by AnLu on
 * 2017/7/6 10:31.
 * JavaEE_Framework
 */
public class Service {
    public static void main(String[] args) {
//        Business business = new Business(new FloppyWriter());
        Business business = new Business(new UsbWriter());
        business.write();
    }
}
