package ardwloop.demo.view;

import org.llschall.ardwloop.motor.AbstractLoop;

public class DemoRefresher extends AbstractLoop {

    final DemoView view;

    protected DemoRefresher(DemoView view) {
        super("Refresher");
        this.view = view;
    }

    @Override
    public void loop() {
        view.refresh();
    }

    @Override
    public void close() {
        // do nothing
    }
}
