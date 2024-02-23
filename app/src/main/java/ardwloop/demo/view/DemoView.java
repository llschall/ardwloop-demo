package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import ardwloop.demo.model.DemoModel;
import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.motor.AbstractLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoView extends JFrame {

    DemoModel model;

    AbstractLoop refresher;

    public DemoView(DemoModel model) {
        this.model = model;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ardwloop Demo");
        setSize(400, 300);
    }

    public void init(DemoController controller) {

        refresher = new DemoViewRefresher(this);

        JLabel versionLbl = new JLabel("Featuring Ardwloop " + ArdwloopStarter.ARDWLOOP_VERSION);
        versionLbl.setFont(versionLbl.getFont().deriveFont(Font.ITALIC, 9f));
        JPanel versionPnl = new JPanel(new FlowLayout());
        versionPnl.add(versionLbl);

        JLabel connectionLbl = new JLabel();
        connectionLbl.setText(model.isConnected() ? "Connected" : "Not connected");

        JPanel commandPnl = new JPanel(new GridLayout(0, 1));
        StartPanel startPnl = new StartPanel(controller);
        commandPnl.add(startPnl);
        commandPnl.add(new LinePanel(controller, DemoCommands.LED_ON, DemoCommands.LED_OFF));
        commandPnl.add(new LinePanel(controller, DemoCommands.EXIT));

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(versionPnl);
        add(commandPnl);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new DemoKeyListener(controller));

        setVisible(true);
    }

    public AbstractLoop getRefresher() {
        return refresher;
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