package ardwloop.demo.model;

import org.llschall.ardwloop.IArdwProgram;
import org.llschall.ardwloop.structure.data.SerialData;

import java.util.concurrent.atomic.AtomicBoolean;

public class DemoProgram implements IArdwProgram {

    final AtomicBoolean isLedOn = new AtomicBoolean();

    @Override
    public SerialData loop(SerialData serialData) {
        int v = isLedOn.get()?1:0;
        return new SerialData(1,v,3,4,5,6);
    }

    @Override
    public SerialData setup(SerialData serialData) {
        return new SerialData(1,2,3,4,5,6);
    }

    @Override
    public int getRc() {
        return 1;
    }

    @Override
    public int getSc() {
        return 1;
    }

    public void switchLed(boolean isOn) {
        isLedOn.set(isOn);
    }
}
