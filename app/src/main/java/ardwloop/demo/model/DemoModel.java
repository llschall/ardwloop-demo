package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwLoopStarter;
import org.llschall.ardwloop.motor.AbstractLoop;

public class DemoModel {

    boolean isConnected;

    public void start() {
        DemoProgram program = new DemoProgram();
        ArdwLoopStarter.get().start(program, new AbstractLoop("demo") {
            @Override
            public void loop() {
                // do nothing for now
            }
            @Override
            public void close() {
                // do nothing for now
            }
        });
    }

    public void exit() {
        System.exit(0);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
