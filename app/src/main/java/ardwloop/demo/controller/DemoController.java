package ardwloop.demo.controller;

import ardwloop.demo.model.DemoModel;
import ardwloop.demo.view.DemoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoController implements ActionListener {

    final DemoModel model;
    final DemoView view;

    public DemoController() {
        model = new DemoModel();
        view = new DemoView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.exit();
    }

    public void launch() {
        view.init(this);
    }

}
