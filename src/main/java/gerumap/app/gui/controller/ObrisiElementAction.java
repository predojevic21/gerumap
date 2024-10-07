package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ObrisiElementAction extends AbstractGeRuMapAction{

    public ObrisiElementAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/deleteicon.png"));
        putValue(NAME, "Delete Element");
        putValue(SHORT_DESCRIPTION, "Delete Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getProjectView().startObrisistate();
    }
}
