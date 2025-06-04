package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

public class LedPanel extends JPanel {

    final JLabel countLbl = new JLabel("Count: -");
    final JLabel sentLbl = new JLabel("Sent: -");

    public LedPanel(DemoController controller) {

        setLayout(new BorderLayout());
        add(new LinePanel(
                controller,
                DemoCommands.LED_ON,
                DemoCommands.LED_OFF,
                DemoCommands.SWITCH
        ), BorderLayout.CENTER);

        JPanel southPnl = new JPanel(new GridLayout(0, 1)) {{
            add(countLbl);
            add(sentLbl);
        }};

        add(southPnl, BorderLayout.SOUTH);
    }

    void refresh(int count, int ax, int ay, int az, int bx, int by, int bz) {
        countLbl.setText("Count: " + count);
        sentLbl.setText("ax: " + ax + ", ay: " + ay + ", az: " + az
                + ", bx: " + bx + ", by: " + by + ", bz: " + bz);
    }
}
