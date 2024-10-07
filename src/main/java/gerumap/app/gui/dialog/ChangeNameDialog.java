package gerumap.app.gui.dialog;

import gerumap.app.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ChangeNameDialog extends JOptionPane {

    private String name;
    public ChangeNameDialog() {
        name = showInputDialog(MainFrame.getInstance(), "Upisite naziv novog projekta");
        setVisible(true);
    }

    @Override
    public String getName() {
        return name;
    }

}
