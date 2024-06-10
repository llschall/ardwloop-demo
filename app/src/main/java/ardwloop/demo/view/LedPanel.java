package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

public class LedPanel extends JPanel {

    final JLabel countLbl = new JLabel("Count: -");

    public LedPanel(DemoController controller) {

        setLayout(new BorderLayout());
        add(new LinePanel(
                controller,
                DemoCommands.LED_ON,
                DemoCommands.LED_OFF,
                DemoCommands.SWITCH
        ), BorderLayout.CENTER);
        add(countLbl, BorderLayout.SOUTH);
    }

    void refresh(int count) {
        countLbl.setText("Count: " + count);
    }
}
