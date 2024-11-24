package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.IArdwConfig;
import org.llschall.ardwloop.motor.AbstractLoop;
import org.llschall.ardwloop.structure.model.ArdwloopModel;

/**
 * The Model of the MVC pattern.
 */
public class DemoModel {

    final DemoProgram program = new DemoProgram();

    ArdwloopModel model;

    public void start(AbstractLoop refresher) {
        ArdwloopStarter.get().setSelector(new CustomSelector());
        model = ArdwloopStarter.get().start(program, IArdwConfig.BAUD_19200, refresher);
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