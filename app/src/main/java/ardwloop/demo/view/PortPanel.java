package ardwloop.demo.view;

import ardwloop.demo.model.CustomSelector;
import org.llschall.ardwloop.serial.ArdwPortDescriptor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class PortPanel extends JPanel {

    PortPanel() {

        CustomSelector selector = new CustomSelector();

        List<ArdwPortDescriptor> ports = selector.list();

        DemoTableModel model = new DemoTableModel();
        int selection = -1;

        for (int i = 0; i < ports.size(); i++) {
            var port = ports.get(i);
            boolean select = selector.select(port);
            model.addRow(new Object[]{select, port.getName(), port.getDescription(), port.getSystemName()});
            if (select && selection == -1) {
                selection = i;
            }
        }

        JTable table = new JTable(model);

        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.CYAN);

        if (selection != -1) {
            table.setRowSelectionInterval(selection, selection);
        }

        JScrollPane pane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(pane, BorderLayout.CENTER);
    }
}

class DemoTableModel extends DefaultTableModel {

    final String[] colums = {"Valid", "Name", "Description", "System Name"};


    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }
}