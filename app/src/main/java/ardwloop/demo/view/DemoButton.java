package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;

import javax.swing.*;

public class DemoButton extends JButton {

    public final DemoCommands command;

    public DemoButton(DemoController controller, DemoCommands command) {
        super(command.name());
        this.command = command;
        addActionListener(controller);
    }
}
