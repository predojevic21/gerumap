package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddCenterElementAction extends AbstractGeRuMapAction{

    public AddCenterElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/centerElement.png"));
        putValue(NAME, "Add Center Element");
        putValue(SHORT_DESCRIPTION, "Add Center Element");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddCeenterElementState();
    }
}
