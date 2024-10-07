package gerumap.app.gui.dialog;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;

public class ChangeAuthorDialog extends JOptionPane {

    private String name;
    public ChangeAuthorDialog() {
        name = showInputDialog(MainFrame.getInstance(), "Upisite naziv autora");
        setVisible(true);
    }

    @Override
    public String getName() {
        return name;
    }
}
