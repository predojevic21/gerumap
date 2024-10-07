package gerumap.app.repository.model.factory.composite;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.model.factory.NodeFactory;

public class MindMapFactory extends NodeFactory {

    @Override
    public MapNode createNode(MapNode parent) {
        String name="MindMap " + Integer.toString(MindMap.redniBroj++);
        MindMap mindMap=new MindMap(name,parent);
        return mindMap;
    }
}
