package gerumap.app.repository.implementation;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Project){
            Project project = (Project) child;
            child.setParent(this);
            if (!this.getChildren().contains(project)){
                this.getChildren().add(project);
            }

        }
        notifySubscribers(child,"add");
    }


}
