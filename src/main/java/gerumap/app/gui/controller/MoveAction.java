package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractGeRuMapAction{

    public MoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/moveElement.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startMovestate();

    }
}
