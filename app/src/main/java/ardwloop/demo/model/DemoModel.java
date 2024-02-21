package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;

public class DemoModel {

    boolean isConnected;

    public void start() {
        DemoProgram program = new DemoProgram();
        ArdwloopStarter.get().start(program);
    }

    public void exit() {
        System.exit(0);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
