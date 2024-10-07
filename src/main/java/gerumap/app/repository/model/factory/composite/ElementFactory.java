package gerumap.app.repository.model.factory.composite;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.model.factory.NodeFactory;

public class ElementFactory extends NodeFactory {

    @Override
    public MapNode createNode(MapNode parent) {
        String name="Element " + Integer.toString(Element.redniBroj++);
        Element element=new Element(name,parent);
        return element;
    }
}
