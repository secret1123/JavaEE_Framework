package demo.b;

/**
 * Created by AnLu on
 * 2017/7/6 09:46.
 * JavaEE_Framework
 */
public class UsbWriter implements DeviceWriter{

    @Override
    public void writeToDevice() {
        System.out.println("write to USB.");
    }
}
