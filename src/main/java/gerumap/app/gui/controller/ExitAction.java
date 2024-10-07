package gerumap.app.gui.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static javax.swing.Action.SHORT_DESCRIPTION;

public class ExitAction extends AbstractGeRuMapAction{
    public ExitAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/exiticon.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }

}
