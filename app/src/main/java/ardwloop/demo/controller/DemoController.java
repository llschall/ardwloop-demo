package ardwloop.demo.controller;

import ardwloop.demo.model.DemoModel;
import ardwloop.demo.utils.DemoException;
import ardwloop.demo.view.DemoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoController implements ActionListener {

    final DemoModel model;
    final DemoView view;

    public DemoController() {
        model = new DemoModel();
        view = new DemoView(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof DemoButton button) {
            switch (button.command) {
                case START -> model.start();
                case EXIT -> model.exit();
            }
        }
        throw new DemoException("Unexpected event: "+e.getClass().getName());
    }

    public void launch() {
        view.init(this);
    }

}