package ardwloop.demo;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.ArdwloopStarter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetupTest {

    @Test
    public void testSetup() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void checkVersion() {
        assertEquals(1001, ArdwloopStarter.VERSION_INT);
    }

}
