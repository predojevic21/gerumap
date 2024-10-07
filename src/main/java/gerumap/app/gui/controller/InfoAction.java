package gerumap.app.gui.controller;

import gerumap.app.gui.dialog.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractGeRuMapAction{

    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F3, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/infoicon.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setVisible(true);
    }
}
