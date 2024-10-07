package gerumap.app.repository.implementation;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Project extends MapNodeComposite {

    protected String filePath;
    protected boolean changed = true;

    public static int redniBroj=1;
    private String autor;

    public Project(String name, MapNode parent,String autor) {
        super(name, parent);
        this.autor=autor;
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
            }
            notifySubscribers(child,"add");
        }
        changed=true;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        changed=true;
    }
}
