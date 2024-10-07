package gerumap.app.gui.tree;

import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.tree.view.MapTreeView;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;

public interface MapTree {
    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent, MapNode child);
    void deleteFromParent(MapTreeItem item);
    MapTreeItem getSelectedNode();
    void loadProject(Project node);
    void loadScheme(MapTreeItem root,MindMap map);

}
