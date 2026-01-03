package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import ardwloop.demo.model.DemoModel;
import org.llschall.ardwloop.ArdwloopStarter;
import org.llschall.ardwloop.ArdwloopStatus;
import org.llschall.ardwloop.motor.AbstractLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * The View of the MVC pattern.
 */
public class DemoView extends JFrame {

    final DemoModel model;

    AbstractLoop refresher;

    PortPanel portPnl;
    StartPanel startPnl;
    LedPanel ledPnl;

    public DemoView(DemoModel model) {
        this.model = model;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ardwloop Demo");
        setSize(400, 700);
    }

    public void init(DemoController controller) {

        refresher = new DemoRefresher(this);

        JLabel versionLbl = new JLabel("Featuring Ardwloop " + ArdwloopStarter.VERSION);
        versionLbl.setFont(versionLbl.getFont().deriveFont(Font.ITALIC, 9f));
        JPanel versionPnl = new JPanel(new FlowLayout());
        versionPnl.add(versionLbl);

        portPnl = new PortPanel();
        startPnl = new StartPanel(controller);
        ledPnl = new LedPanel(controller);
        LinePanel exitPnl = new LinePanel(controller, DemoCommands.EXIT);

        JPanel commandPnl = new JPanel(new GridLayout(0, 1));
        for (JPanel pnl : Arrays.asList(portPnl, startPnl, ledPnl, exitPnl)) {
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

    public void refresh(ArdwloopStatus status) {
        startPnl.connectionLbl.setText(status.name());
    }

    public void refresh() {
        startPnl.refresh(
                model.getPortName(),
                model.isConnected()
        );
        ledPnl.refresh(model.getCount(),
                model.getAx(),
                model.getAy(),
                model.getAz(),
                model.getBx(),
                model.getBy(),
                model.getBz()
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
        if (c == 's') {
            controller.handleCommand(DemoCommands.START);
        }
        if (c == KeyEvent.VK_SPACE) {
            controller.handleCommand(DemoCommands.SWITCH);
        }
        if (c == KeyEvent.VK_ESCAPE) {
            controller.handleCommand(DemoCommands.EXIT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
}