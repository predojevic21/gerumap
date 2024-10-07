package gerumap.app.gui.controller;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.dialog.ChangeAuthorDialog;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChangeAutor extends AbstractGeRuMapAction{

    public ChangeAutor() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/changeAuthror.png"));
        putValue(NAME, "Change Author");
        putValue(SHORT_DESCRIPTION, "Change Author");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NODE_NOT_SELECTED);
        }
        else if(selected.getMapNode() instanceof Project ) {
            ChangeAuthorDialog dialog=new ChangeAuthorDialog();
            dialog.setVisible(true);

            if(dialog.getName().isEmpty()){
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NAME_CANNOT_BE_EMPTY);
                return;
            }
            ((Project) selected.getMapNode()).setAutor(dialog.getName());
            selected.getMapNode().notifySubscribers(dialog.getName(), "autor");
        }

    }
}
