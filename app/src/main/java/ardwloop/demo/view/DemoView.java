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
import java.util.Arrays;

public class DemoView extends JFrame {

    final DemoModel model;

    AbstractLoop refresher;

    StartPanel startPnl;
    LedPanel ledPnl;

    public DemoView(DemoModel model) {
        this.model = model;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ardwloop Demo");
        setSize(400, 300);
    }

    public void init(DemoController controller) {

        refresher = new DemoRefresher(this);

        JLabel versionLbl = new JLabel("Featuring Ardwloop " + ArdwloopStarter.VERSION);
        versionLbl.setFont(versionLbl.getFont().deriveFont(Font.ITALIC, 9f));
        JPanel versionPnl = new JPanel(new FlowLayout());
        versionPnl.add(versionLbl);

        startPnl = new StartPanel(controller);
        ledPnl = new LedPanel(controller);
        LinePanel exitPnl = new LinePanel(controller, DemoCommands.EXIT);

        JPanel commandPnl = new JPanel(new GridLayout(0, 1));
        for (JPanel pnl : Arrays.asList(startPnl, ledPnl, exitPnl)) {
            pnl.setBorder(BorderFactory.createEtchedBorder());
            commandPnl.add(pnl);
        }

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

    public void refresh() {
        startPnl.refresh(
                model.getPortName(),
                model.isConnected()
        );
        ledPnl.refresh(model.getCount()
        );
    }
}

class LinePanel extends JPanel {
    public LinePanel(DemoController controller, DemoCommands... commands) {
        for (DemoCommands command : commands) {
            DemoButton button = new DemoButton(controller, command);
            button.setFocusable(false);
            add(button);
        }
    }
}

record DemoKeyListener(DemoController controller) implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        if (KeyEvent.VK_ESCAPE == c) {
            controller.handleCommand(DemoCommands.EXIT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
}