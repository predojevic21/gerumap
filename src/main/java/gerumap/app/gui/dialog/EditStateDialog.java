package gerumap.app.gui.dialog;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditStateDialog extends JOptionPane {

    private String name;
    public EditStateDialog() {
        name = showInputDialog(MainFrame.getInstance(),"Unesite naziv pojma : ");
        setVisible(true);
    }

    @Override
    public String getName() {
        return name;
    }
}
