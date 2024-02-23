package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

class StartPanel extends JPanel {

    StartPanel(DemoController controller) {

        JPanel centerPnl = new LinePanel(controller, DemoCommands.START);

        setLayout(new BorderLayout());
        add(centerPnl, BorderLayout.CENTER);

    }
}
