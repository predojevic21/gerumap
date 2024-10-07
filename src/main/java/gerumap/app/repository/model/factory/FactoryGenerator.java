package gerumap.app.repository.model.factory;

import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;
import gerumap.app.repository.model.factory.composite.ElementFactory;
import gerumap.app.repository.model.factory.composite.MindMapFactory;
import gerumap.app.repository.model.factory.composite.ProjectFactory;
import gerumap.app.repository.view.ProjectView;

public class FactoryGenerator {
    public static ElementFactory elementFactory=new ElementFactory();
    public static MindMapFactory mindMapFactory=new MindMapFactory();
    public static ProjectFactory projectFactory=new ProjectFactory();


    public static NodeFactory returnNodeFactory(MapTreeItem mapTreeItem){
        if(mapTreeItem.getMapNode() instanceof MindMap)
            return elementFactory;
        else if(mapTreeItem.getMapNode() instanceof Project)
            return mindMapFactory;
        else if(mapTreeItem.getMapNode() instanceof ProjectExplorer)
            return projectFactory;


      return null;
    }

}
