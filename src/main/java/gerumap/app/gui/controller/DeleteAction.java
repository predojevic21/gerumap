package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGeRuMapAction{
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/deleteicon.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_NOT_SELECTED);
        }else if(selected.getMapNode() instanceof ProjectExplorer){
          ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_CANNOT_BE_DELETED);
        } else if(!(selected.getMapNode() instanceof Element)){
            MainFrame.getInstance().getMapTree().deleteFromParent(selected);
        }
    }
}
