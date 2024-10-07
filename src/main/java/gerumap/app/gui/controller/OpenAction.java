package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends AbstractGeRuMapAction{

    public OpenAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                Project p = ApplicationFramework.getInstance().getSerializer().loadProject(file);
                MainFrame.getInstance().getMapTree().loadProject(p);
                MainFrame.getInstance().getProjectView().setProject(p);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
