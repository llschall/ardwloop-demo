package ardwloop.demo.model;

import org.llschall.ardwloop.IArdwProgram;
import org.llschall.ardwloop.structure.data.SerialData;
import org.llschall.ardwloop.value.V;
import org.llschall.ardwloop.value.ValueMap;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@link DemoProgram} class implements the {@link IArdwProgram}, which makes it responsible for the communication
 * with the Arduino Board.
 */
public class DemoProgram implements IArdwProgram {

    /// True if the LED should be switched on the Arduino board.
    final AtomicBoolean isLedOn = new AtomicBoolean();

    /// The count received from the Arduino board.
    final AtomicInteger count = new AtomicInteger();

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

    /// Called once, after the communication with the Arduino is established.
    @Override
    public ValueMap ardwSetup(ValueMap setup) {
        // These values do not matter here, as the Arduino board won't process them anyhow.
        return new ValueMap();
    }

    /**
     * Repeatedly called, in the same rhythm as the loop() method on the Arduino board.
     *
     * @param input The {@link ValueMap} received by the Arduino board
     * @return The {@link ValueMap} to be sent to the Arduino board.
     */
    @Override
    public ValueMap ardwLoop(ValueMap input) {

        // ****************************************************
        // 1) Process the data received from the Arduino board.
        // ****************************************************

        // Retrieve the a.x value provided by the Arduino board.
        int x = input.a.x;

        // Update the count with the x value.
        count.set(x);

        // ***********************************************************************
        // 2) Set and wrap the data to be sent and processed by the Arduino board.
        // ***********************************************************************

        // Set v with 1 if the Arduino board should switch on the LED, with 0 if it should switch off the LED.
        int v = isLedOn.get() ? 1 : 0;

        // Wrap v in the output, that will be imminently sent to the Arduino board.
        ValueMap output = new ValueMap();
        output.a.v = v;
        return output;
    }

}
