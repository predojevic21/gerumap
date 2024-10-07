package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.dialog.ChangeNameDialog;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChangeName extends AbstractGeRuMapAction{

    public ChangeName() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/changeName.png"));
        putValue(NAME, "Change Name");
        putValue(SHORT_DESCRIPTION, "Change Name");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_NOT_SELECTED);
        } else if (selected.getMapNode() instanceof Project) {
            ChangeNameDialog changeName = new ChangeNameDialog();
            changeName.setVisible(true);
            if (changeName.getName().isEmpty()) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NAME_CANNOT_BE_EMPTY);
                return;
            }
            selected.setName(changeName.getName());
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());
            selected.getMapNode().notifySubscribers(changeName.getName(), "ime");
        }
    }
}
