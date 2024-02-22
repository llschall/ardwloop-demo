package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import ardwloop.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;

public class DemoView extends JFrame {

    DemoModel model;

    public DemoView(DemoModel model) {
        this.model = model;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ardwloop demo");
        setSize(400, 300);
    }

    public void init(DemoController controller) {

        JLabel connectionLbl = new JLabel();
        connectionLbl.setText(model.isConnected() ? "Connected" : "Not connected");

        setLayout(new GridLayout(0, 1));
        add(new LinePanel(controller, DemoCommands.START));
        add(new LinePanel(controller, DemoCommands.LED_ON, DemoCommands.LED_OFF));
        add(new LinePanel(controller, DemoCommands.EXIT));
        setVisible(true);
    }
}


class LinePanel extends JPanel {

    public LinePanel(DemoController controller, DemoCommands... commands) {
        super(new FlowLayout());
        for (DemoCommands command : commands) {
            add(new DemoButton(controller, command));
        }
    }
}