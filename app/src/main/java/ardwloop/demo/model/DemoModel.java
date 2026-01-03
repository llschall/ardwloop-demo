package ardwloop.demo.model;

import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.ArdwloopStatus;
import org.llschall.ardwloop.IArdwConfig;
import org.llschall.ardwloop.motor.AbstractLoop;
import org.llschall.ardwloop.structure.model.ArdwloopModel;

import java.util.function.Consumer;

/**
 * The Model of the MVC pattern.
 */
public class DemoModel {

    final DemoProgram program;

    ArdwloopModel model;

    public ArdwloopStatus status;

    public DemoModel(Consumer<ArdwloopStatus> fireStatusChanged) {
        this.program = new DemoProgram(fireStatusChanged);
    }

    public void start(AbstractLoop refresher) {
        ArdwloopStarter.get().setRetryConnection(true);
        ArdwloopStarter.get().setSelector(new CustomSelector());
        model = ArdwloopStarter.get().start(program, IArdwConfig.BAUD_9600, refresher);
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

    public int getAx() {
        return program.ax.get();
    }

    public int getAy() {
        return program.ay.get();
    }

    public int getAz() {
        return program.az.get();
    }

    public int getBx() {
        return program.bx.get();
    }

    public int getBy() {
        return program.by.get();
    }

    public int getBz() {
        return program.bz.get();
    }
}