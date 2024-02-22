package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;

public class DemoModel {

    DemoProgram program = new DemoProgram();

    boolean isConnected;

    public void start() {
        ArdwloopStarter.get().start(program);
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
