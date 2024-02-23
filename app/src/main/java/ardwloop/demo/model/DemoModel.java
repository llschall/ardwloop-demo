package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.motor.AbstractLoop;

public class DemoModel {

    DemoProgram program = new DemoProgram();

    boolean isConnected;

    public void start(AbstractLoop refresher) {
        ArdwloopStarter.get().start(program, refresher);
    }

    public void switchLed(boolean isOn) {
        program.switchLed(isOn);
    }

    public void exit() {
        System.exit(0);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
