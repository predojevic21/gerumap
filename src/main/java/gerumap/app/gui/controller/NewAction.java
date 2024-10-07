package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.tree.MapTree;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;
import gerumap.app.repository.model.factory.FactoryGenerator;
import gerumap.app.repository.model.factory.NodeFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractGeRuMapAction{
    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/newIcon.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_NOT_SELECTED);
        } else if(selected.getMapNode() instanceof Element){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_CANNOT_HAVE_CHILDREN);
        } else {
            MapNode child = FactoryGenerator.returnNodeFactory(selected).getNode(selected);
            if(!(child instanceof Element))
                MainFrame.getInstance().getMapTree().addChild(selected, child);
        }
    }
}
