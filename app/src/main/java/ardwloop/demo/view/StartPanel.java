package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import org.llschall.ardwloop.ArdwloopStatus;

import javax.swing.*;
import java.awt.*;

class StartPanel extends JPanel {

    final JLabel portLbl;
    final JLabel connectionLbl;

    StartPanel(DemoController controller) {

        String notStarted = "Not started";

        JPanel northPnl = new LinePanel(controller, DemoCommands.START);

        portLbl = new JLabel();
        portLbl.setText(notStarted);

        connectionLbl = new JLabel();
        connectionLbl.setText(notStarted);

        JPanel centerPnl = new JPanel(new FlowLayout());
        centerPnl.add(portLbl);
        centerPnl.add(connectionLbl);

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);

        northPnl.setOpaque(false);
        centerPnl.setOpaque(false);
    }

    void refresh(String port, ArdwloopStatus status, boolean isConnected) {

        portLbl.setText("Port: " + port);
        connectionLbl.setText(status.name());

        setBackground(isConnected ? Color.GREEN : Color.LIGHT_GRAY);
    }
}
