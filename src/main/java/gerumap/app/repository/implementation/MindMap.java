package gerumap.app.repository.implementation;

import com.sun.security.jgss.GSSUtil;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;

import java.security.spec.RSAOtherPrimeInfo;

public class MindMap extends MapNodeComposite {
    public static int redniBroj = 1;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
            Project parent=(Project)this.getParent();
            parent.changed=true;
            notifySubscribers(child, "add");
        }
    }

}
