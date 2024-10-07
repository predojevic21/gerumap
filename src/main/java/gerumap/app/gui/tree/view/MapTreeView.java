package gerumap.app.gui.tree.view;

import gerumap.app.gui.tree.MapTreeImplementation;
import gerumap.app.gui.tree.controller.MapTreeCellEditor;
import gerumap.app.gui.tree.controller.MapTreeSelectionListener;
import gerumap.app.gui.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        MapTreeCellRenderer ruTreeCellRenderer = new MapTreeCellRenderer();
        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }



}
