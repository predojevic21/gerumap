package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddVezaAction extends AbstractGeRuMapAction{

    public AddVezaAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/addVeza.png"));
        putValue(NAME, "Add Veza");
        putValue(SHORT_DESCRIPTION, "Add Veza");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddVezaState();

    }
}
