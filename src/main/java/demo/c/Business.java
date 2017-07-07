package demo.c;

/**
 * Created by AnLu on
 * 2017/7/6 10:40.
 * JavaEE_Framework
 */
public class Business {
    private DeviceWriter deviceWriter;

//    public Business(DeviceWriter deviceWriter){
//        this.deviceWriter = deviceWriter;
//    }

public void setDeviceWriter(DeviceWriter deviceWriter){
    this.deviceWriter = deviceWriter;
}
    public void write(){
        deviceWriter.writeToDevice();
    }
}
