package demo.c;


/**
 * Created by AnLu on
 * 2017/7/6 09:45.
 * JavaEE_Framework
 */
public class FloppyWriter implements DeviceWriter {

    @Override
    public void writeToDevice() {
        System.out.println("write to floppy.");
    }
}
