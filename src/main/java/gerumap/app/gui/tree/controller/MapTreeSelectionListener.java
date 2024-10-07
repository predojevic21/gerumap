package gerumap.app.gui.tree.controller;

import gerumap.app.Main;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.view.ProjectView;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem)path.getLastPathComponent();
     //   System.out.println("Selektovan cvor:"+ treeItemSelected.getMapNode().getName());
      //  System.out.println("getPath: "+e.getPath());

        if(treeItemSelected.getMapNode() instanceof Project){
            MapNode mapNode = treeItemSelected.getMapNode();
            MainFrame.getInstance().getProjectView().setProject((Project) mapNode);
            //System.out.println("broj elemenata project" + MainFrame.getInstance().getProjectView().getCurrentMindMapView().getPainteri().size());
        } else if(treeItemSelected.getMapNode() instanceof MindMap){
            MapNode mapNode = treeItemSelected.getMapNode();
            MainFrame.getInstance().getProjectView().setProject((Project)mapNode.getParent());
        }
    }
}
