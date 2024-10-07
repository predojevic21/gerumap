package gerumap.app.gui.controller;

import gerumap.app.gui.dialog.EditStateDialog;
import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditStateAction extends AbstractGeRuMapAction {

    public EditStateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit element");
        putValue(SHORT_DESCRIPTION, "Edit element");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startEditState();
     //   EditStateDialog editStateDialog = new EditStateDialog();
     //   editStateDialog.setVisible(true);
    }
}
