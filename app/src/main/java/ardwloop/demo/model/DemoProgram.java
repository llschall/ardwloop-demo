package ardwloop.demo.model;

import ardwloop.demo.view.DemoRefresher;
import ardwloop.demo.view.DemoView;
import kotlin.Function;
import org.llschall.ardwloop.ArdwloopStatus;
import org.llschall.ardwloop.IArdwProgram;
import org.llschall.ardwloop.value.SerialData;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * The {@link DemoProgram} class implements the {@link IArdwProgram}, which makes it responsible for the communication
 * with the Arduino Board.
 */
public class DemoProgram implements IArdwProgram {
    /// True if the LED should be switched on the Arduino board.
    final AtomicBoolean isLedOn = new AtomicBoolean();

    /// The count received from the Arduino board.
    final AtomicInteger count = new AtomicInteger();

    final AtomicInteger ax = new AtomicInteger();
    final AtomicInteger ay = new AtomicInteger();
    final AtomicInteger az = new AtomicInteger();
    final AtomicInteger bx = new AtomicInteger();
    final AtomicInteger by = new AtomicInteger();
    final AtomicInteger bz = new AtomicInteger();

    final Consumer<ArdwloopStatus> fireStatusChanged;

    public DemoProgram(Consumer<ArdwloopStatus> fireStatusChanged) {
        this.fireStatusChanged = fireStatusChanged;
    }

    /**
     * Switches the isLedOn value to its other one.
     */
    public void switchLed() {
        isLedOn.set(!isLedOn.get());
    }

    /**
     * @param isOn THe new value for isLedOn
     */
    public void switchLed(boolean isOn) {
        isLedOn.set(isOn);
    }

    @Override
    public void fireStatusChanged(ArdwloopStatus status) {
        System.out.println("status = " + status);
        fireStatusChanged.accept(status);
    }

    /// Called once, after the communication with the Arduino is established.
    @Override
    public SerialData ardwSetup(SerialData setup) {
        // These values do not matter here, as the Arduino board won't process them anyhow.
        return new SerialData();
    }

    /**
     * Repeatedly called, in the same rhythm as the loop() method on the Arduino board.
     *
     * @param input The {@link SerialData} received by the Arduino board
     * @return The {@link SerialData} to be sent to the Arduino board.
     */
    @Override
    public SerialData ardwLoop(SerialData input) {

        // ****************************************************
        // 1) Process the data received from the Arduino board.
        // ****************************************************

        // Retrieve the a.x value provided by the Arduino board.
        int x = input.a.x;

        // Update the count with the x value.
        count.set(x);

        // Populate the ax, ay, az, bx, by, bz values with the data received from the Arduino board.
        ax.set(input.a.x);
        ay.set(input.a.y);
        az.set(input.a.z);
        bx.set(input.b.x);
        by.set(input.b.y);
        bz.set(input.b.z);

        // ***********************************************************************
        // 2) Set and wrap the data to be sent and processed by the Arduino board.
        // ***********************************************************************

        // Set v with 1 if the Arduino board should switch on the LED, with 0 if it should switch off the LED.
        int v = isLedOn.get() ? 1 : 0;

        // Wrap v in the output, that will be imminently sent to the Arduino board.
        SerialData output = new SerialData();
        output.a.v = v;
        return output;
    }

}
