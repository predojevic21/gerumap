package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAction extends AbstractGeRuMapAction {

    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getFilePath() == null || project.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            } else {
                return;
            }

        }


        ApplicationFramework.getInstance().getSerializer()
                .saveProject(project);

        project.setChanged(false);
    }
}
