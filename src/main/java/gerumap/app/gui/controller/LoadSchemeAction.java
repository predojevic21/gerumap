package gerumap.app.gui.controller;

import gerumap.app.Main;
import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

public class LoadSchemeAction extends AbstractGeRuMapAction{
    public LoadSchemeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/openmm.png"));
        putValue(NAME, "Load scheme");
        putValue(SHORT_DESCRIPTION, "Load scheme");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getMapNode() instanceof Project) {
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File("src/main/resources/schemes/"));
            if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = jfc.getSelectedFile();
                    MindMap mindMap = ApplicationFramework.getInstance().getSerializer().loadScheme(file);
                    MainFrame.getInstance().getMapTree().loadScheme(selected,mindMap);
                    MainFrame.getInstance().getProjectView().setProject((Project) mindMap.getParent());

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
