package ardwloop.demo.view;

import ardwloop.demo.controller.DemoButton;
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
        setSize(400,300);
    }

    public void init(DemoController controller) {

        JLabel connectionLbl = new JLabel();
        connectionLbl.setText(model.isConnected()?"Connected":"Not connected");

        setLayout(new BorderLayout());
        add(new DemoButton(controller, DemoCommands.START), BorderLayout.NORTH);
        add(new DemoButton(controller, DemoCommands.EXIT), BorderLayout.SOUTH);
        setVisible(true);
    }
}
