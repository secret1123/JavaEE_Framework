package demo.a;

/**
 * Created by AnLu on
 * 2017/7/6 09:29.
 * JavaEE_Framework
 */
public class Business {
    private FloppyWriter floppyWriter;
    private UsbWriter usbWriter;

    public Business(UsbWriter usbWriter){
        this.usbWriter = usbWriter;
    }

    public Business(FloppyWriter floppyWriter){
        this.floppyWriter = floppyWriter;
    }

    public void write(){
        floppyWriter.writerToFloppy();

        usbWriter.writeToUsb();
    }
}
