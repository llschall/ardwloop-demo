package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

class StartPanel extends JPanel {

    final JLabel connectionLbl;

    StartPanel(DemoController controller) {


        JPanel northPnl = new LinePanel(controller, DemoCommands.START);

        connectionLbl = new JLabel();
        connectionLbl.setText("Not started");
        JPanel centerPnl = new JPanel(new FlowLayout());
        centerPnl.add(connectionLbl);

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
    }

    void refresh(boolean isConnected) {
        connectionLbl.setText(isConnected?"Connected":"Not connected");
    }
}
