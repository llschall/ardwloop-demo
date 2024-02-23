package ardwloop.demo.view;

import org.llschall.ardwloop.motor.AbstractLoop;

public class DemoViewRefresher extends AbstractLoop {

    final DemoView view;

    protected DemoViewRefresher(DemoView view) {
        super("Refresher");
        this.view = view;
    }

    @Override
    public void loop() {
        System.out.println("Refresher.loop");
    }

    @Override
    public void close() {
        System.out.println("Refresher.close");
    }
}
