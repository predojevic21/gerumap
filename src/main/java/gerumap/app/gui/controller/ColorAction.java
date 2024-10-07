package gerumap.app.gui.controller;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ColorAction extends AbstractGeRuMapAction{

    public ColorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/color.png"));
        putValue(NAME, "Change color");
        putValue(SHORT_DESCRIPTION, "Change color");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startColorState();
    }

}
