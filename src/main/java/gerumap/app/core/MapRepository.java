package gerumap.app.core;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;

public interface MapRepository {
    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);
}
