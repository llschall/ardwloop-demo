package ardwloop.demo;

import org.junit.jupiter.api.Test;
import org.llschall.ardwloop.ArdwloopStarter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTest {

    @Test
    public void checkVersion() {
        assertEquals("0.3.3", ArdwloopStarter.VERSION);
        assertEquals(1001, ArdwloopStarter.VERSION_INT);
    }
}
