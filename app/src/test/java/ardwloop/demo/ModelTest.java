package ardwloop.demo;

import ardwloop.demo.model.DemoModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTest {
    @Test
    public void testModel() {
        DemoModel model = new DemoModel();
        Assertions.assertFalse(model.isConnected());
    }
}
