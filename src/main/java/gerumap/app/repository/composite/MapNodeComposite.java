package gerumap.app.repository.composite;

import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter

public abstract class MapNodeComposite extends MapNode {

    List<MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public MapNodeComposite(String name, MapNode parent, List<MapNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(MapNode child);

    public MapNode getChildByName(String name) {
        for (MapNode child : this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public void removeChild(MapNode child) {
        if (child == null)
            return;

            children.remove(child);
            notifySubscribers(child, "delete");

        if (child instanceof Pojam) {
            Pojam p = (Pojam) child;
            Iterator<Veza> iterator = p.getVeze().listIterator();
            while(iterator.hasNext()){
                Veza v = iterator.next();
                iterator.remove();
            }
        }

        if(child instanceof MindMap){
            MindMap map=(MindMap)child;
            Project project=(Project)map.getParent();
            project.setChanged(true);
        }

        }


    }



