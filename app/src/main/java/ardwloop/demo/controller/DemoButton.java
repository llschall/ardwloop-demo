package ardwloop.demo.controller;

import javax.swing.*;

public class DemoButton extends JButton {

    public final DemoCommands command;

    public DemoButton(DemoController controller, DemoCommands command) {
        super(command.name());
        this.command = command;
        addActionListener(controller);
    }
}
