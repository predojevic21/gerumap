package gerumap.app.gui.controller;

import gerumap.app.Main;
import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SaveSchemeAction extends AbstractGeRuMapAction{
    public SaveSchemeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/tamplates.png"));
        putValue(NAME, "Save scheme");
        putValue(SHORT_DESCRIPTION, "Save scheme");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap)) return;

        MindMap mindMap= (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        ApplicationFramework.getInstance().getSerializer().saveScheme(mindMap);

    }
}
