package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.motor.AbstractLoop;
import org.llschall.ardwloop.serial.ArdwPortDescriptor;
import org.llschall.ardwloop.serial.DefaultPortSelector;
import org.llschall.ardwloop.structure.model.ArdwloopModel;

import java.util.List;

/**
 * The Model of the MVC pattern.
 */
public class DemoModel {

    final DemoProgram program = new DemoProgram();

    ArdwloopModel model;

    public void start(AbstractLoop refresher) {
        ArdwloopStarter.get().setSelector(new CustomSelector());
        model = ArdwloopStarter.get().start(program, refresher);
        model.serialMdl.baud.set(9600);
    }

    public void switchLed() {
        program.switchLed();
    }

    public void switchLed(boolean isOn) {
        program.switchLed(isOn);
    }

    public int getCount() {
        return program.count.get();
    }

    public void exit() {
        System.exit(0);
    }

    public boolean isConnected() {
        return model.serialMdl.connected.get();
    }

    public String getPortName() {
        return model.serialMdl.port.name.get();
    }
}