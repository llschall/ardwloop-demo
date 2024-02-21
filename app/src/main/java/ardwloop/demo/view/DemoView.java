package ardwloop.demo.view;

import ardwloop.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

public class DemoView extends JFrame {

    public DemoView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ardwloop demo");
        setSize(400,300);
    }

    public void init(DemoController controller) {
        JButton exit = new JButton("Exit");
        exit.addActionListener(controller);
        setLayout(new BorderLayout());
        add(exit, BorderLayout.SOUTH);
        setVisible(true);
    }
}
