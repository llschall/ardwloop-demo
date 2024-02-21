package ardwloop.demo.model;

import org.llschall.ardwloop.IArdwProgram;
import org.llschall.ardwloop.structure.data.SerialData;

public class DemoProgram implements IArdwProgram {

    @Override
    public SerialData loop(SerialData serialData) {
        return new SerialData(1,2,3,4,5,6);
    }

    @Override
    public SerialData setup(SerialData serialData) {
        return new SerialData(1,2,3,4,5,6);
    }

    @Override
    public int getRc() {
        return 2;
    }

    @Override
    public int getSc() {
        return 2;
    }
}
