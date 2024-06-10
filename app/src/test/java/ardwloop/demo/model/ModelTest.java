package ardwloop.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTest {
    @Test
    public void testModel() {
        DemoModel model = new DemoModel();
        Assertions.assertFalse(model.program.isLedOn.get());
        model.switchLed(true);
        Assertions.assertTrue(model.program.isLedOn.get());
        model.switchLed();
        Assertions.assertFalse(model.program.isLedOn.get());
        model.switchLed();
        Assertions.assertTrue(model.program.isLedOn.get());

    }
}
