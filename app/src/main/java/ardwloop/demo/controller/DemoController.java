package ardwloop.demo.controller;

import ardwloop.demo.model.DemoModel;
import ardwloop.demo.utils.DemoException;
import ardwloop.demo.view.DemoButton;
import ardwloop.demo.view.DemoView;
import org.llschall.ardwloop.ArdwloopStatus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller of the MVC pattern.
 */
public class DemoController implements ActionListener {

    final DemoModel model;
    final DemoView view;

    public DemoController() {
        model = new DemoModel(this::fireStateChanged);
        view = new DemoView(model);
    }

    private void fireStateChanged(ArdwloopStatus status) {
        model.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof DemoButton button) {
            handleCommand(button.command);
            return;
        }
        throw new DemoException("Unexpected event: " + e.getClass().getName());
    }

    public void handleCommand(DemoCommands command) {
        switch (command) {
            case START -> model.start(view.getRefresher());
            case LED_ON -> model.switchLed(true);
            case LED_OFF -> model.switchLed(false);
            case SWITCH -> model.switchLed();
            case EXIT -> model.exit();
        }
    }

    public void launch() {
        view.init(this);
    }

}
