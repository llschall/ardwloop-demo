package ardwloop.demo.model;

import org.llschall.ardwloop.IArdwProgram;
import org.llschall.ardwloop.structure.data.LoopData;
import org.llschall.ardwloop.structure.data.SerialData;
import org.llschall.ardwloop.structure.data.SetupData;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoProgram implements IArdwProgram {

    final AtomicBoolean isLedOn = new AtomicBoolean();
    final AtomicInteger count = new AtomicInteger();

    @Override
    public LoopData ardwLoop(LoopData loop) {

        int x = loop.getData().a.x;
        count.set(x);

        int v = isLedOn.get() ? 1 : 0;
        return new LoopData(new SerialData(1, v, 3, 4, 5, 6));
    }

    @Override
    public SetupData ardwSetup(SetupData setup) {
        return new SetupData(
                new SerialData(1, 2, 3, 4, 5, 6));
    }


    @Override
    public int getReadDelayMs() {
        return 99;
    }

    @Override
    public int getPostDelayMs() {
        return 9999;
    }

    @Override
    public int getRc() {
        return 1;
    }

    @Override
    public int getSc() {
        return 1;
    }

    public void switchLed() {
        isLedOn.set(!isLedOn.get());
    }

    public void switchLed(boolean isOn) {
        isLedOn.set(isOn);
    }
}
