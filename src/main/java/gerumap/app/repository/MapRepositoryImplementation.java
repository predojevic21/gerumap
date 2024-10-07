package gerumap.app.repository;

import gerumap.app.core.MapRepository;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.tree.view.MapTreeView;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;

public class MapRepositoryImplementation implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImplementation() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {

        return this.projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        //TODO: implement add Child method
    }


}
