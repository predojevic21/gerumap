package gerumap.app.repository.implementation;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Element extends MapNode {
    public static int redniBroj=1;
    protected  int color;
    protected int stroke;

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element() {
        super();
    }
}
