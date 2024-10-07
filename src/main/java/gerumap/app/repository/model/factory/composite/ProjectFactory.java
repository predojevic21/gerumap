package gerumap.app.repository.model.factory.composite;

import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.model.factory.NodeFactory;

public class ProjectFactory extends NodeFactory {

    @Override
    public MapNode createNode(MapNode parent) {
        String name="Project " + Integer.toString(Project.redniBroj++);
        Project project=new Project(name,parent,"Autor");
        return project;
    }
}
