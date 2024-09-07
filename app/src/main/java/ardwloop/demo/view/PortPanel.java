package ardwloop.demo.view;

import ardwloop.demo.controller.DemoCommands;
import ardwloop.demo.controller.DemoController;
import org.llschall.ardwloop.serial.ArdwPortDescriptor;

import javax.swing.*;
import java.awt.*;
import java.io.StringWriter;
import java.util.List;

public class PortPanel extends JPanel {

    final JLabel listLbl;

    public PortPanel(DemoController controller) {
        listLbl = new JLabel();

        JPanel northPnl = new LinePanel(controller, DemoCommands.LIST);

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(listLbl, BorderLayout.CENTER);
    }

    public void refresh(List<ArdwPortDescriptor> list) {
        StringWriter writer = new StringWriter();
        for (ArdwPortDescriptor descriptor : list) {
            writer.append(descriptor.getSystemName());
            writer.append(';');
        }
        listLbl.setText(writer.toString());
    }
}
