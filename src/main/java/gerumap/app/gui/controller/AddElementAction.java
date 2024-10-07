package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddElementAction extends AbstractGeRuMapAction{

    public AddElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/addElement.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddPojamState();
    }
}
