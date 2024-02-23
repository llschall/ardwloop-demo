package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.motor.AbstractLoop;
import org.llschall.ardwloop.structure.model.ArdwloopModel;

public class DemoModel {

    DemoProgram program = new DemoProgram();

    ArdwloopModel model;

    public void start(AbstractLoop refresher) {
        model = ArdwloopStarter.get().start(program, refresher);
    }

    public void switchLed(boolean isOn) {
        program.switchLed(isOn);
    }

    public void exit() {
        System.exit(0);
    }

    public boolean isConnected() {
        return model.serialMdl.connected.get();
    }
}
