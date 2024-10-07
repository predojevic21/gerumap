package gerumap.app.repository.model.factory;

import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.repository.composite.MapNode;

public abstract class NodeFactory {

    public MapNode getNode(MapTreeItem mapTreeItem){
        MapNode node=createNode(mapTreeItem.getMapNode());
        return node;
    }

    public abstract MapNode createNode(MapNode parent);

}
