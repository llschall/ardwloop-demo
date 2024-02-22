package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import ardwloop.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new DemoKeyListener(controller));

        setVisible(true);
    }
}

class LinePanel extends JPanel {
    public LinePanel(DemoController controller, DemoCommands... commands) {
        setBorder(BorderFactory.createEtchedBorder());
        for (DemoCommands command : commands) {
            DemoButton button = new DemoButton(controller, command);
            button.setFocusable(false);
            add(button);
        }
    }
}

class DemoKeyListener implements KeyListener {

    final DemoController controller;

    DemoKeyListener(DemoController controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        if (KeyEvent.VK_ESCAPE==c) {
            controller.handleCommand(DemoCommands.EXIT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
}