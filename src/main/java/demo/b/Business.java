package demo.b;

/**
 * Created by AnLu on
 * 2017/7/6 10:30.
 * JavaEE_Framework
 */
public class Business {
    private DeviceWriter deviceWriter;

    public Business(DeviceWriter deviceWriter){
        this.deviceWriter = deviceWriter;
    }

    public void write(){
        deviceWriter.writeToDevice();
    }
}
