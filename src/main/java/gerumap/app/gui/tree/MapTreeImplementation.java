package gerumap.app.gui.tree;

import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.tree.view.MapTreeView;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.composite.MapNodeComposite;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;
import gerumap.app.repository.model.factory.FactoryGenerator;
import lombok.Getter;


import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.Random;

@Getter
public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent,MapNode child) {

        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;


        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void deleteFromParent(MapTreeItem item) {

            item.removeFromParent();
            ((MapNodeComposite) item.getMapNode()).removeChild(item.getMapNode());

        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void loadProject(Project node) {

        node.setSubsribers(new ArrayList<>());
        MapTreeItem loadedProject = new MapTreeItem(node);
        MapTreeItem root=(MapTreeItem)treeModel.getRoot();
        root.add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) root.getMapNode();
        mapNode.addChild(node);

        for(MapNode mn: node.getChildren()){
            MindMap mm=(MindMap) mn;
            mm.setParent(node);
            MapTreeItem treeItem=new MapTreeItem(mm);
            loadedProject.add(treeItem);
        for(MapNode elementi:mm.getChildren()){
            if(elementi instanceof Pojam){
                Pojam p=(Pojam) elementi;
                p.setParent(mm);
                treeItem.add(new MapTreeItem(p));
                p.setSubsribers(new ArrayList<>());
            } else if(elementi instanceof Veza){
                Veza v=(Veza)elementi;
                v.setParent(mm);
                treeItem.add(new MapTreeItem(v));
                v.setSubsribers(new ArrayList<>());
            }
        }
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void loadScheme(MapTreeItem root,MindMap map) {
        MapTreeItem treeMap=new MapTreeItem(map);
        root.add(treeMap);
        map.setParent(root.getMapNode());
        map.setSubsribers(new ArrayList<>());
        MapNodeComposite mapNode = (MapNodeComposite) root.getMapNode();
        mapNode.addChild(map);

        for(MapNode elementi:map.getChildren()){
            if(elementi instanceof Pojam){
                Pojam p=(Pojam) elementi;
                p.setParent(map);
                treeMap.add(new MapTreeItem(p));
                p.setSubsribers(new ArrayList<>());
                System.out.println("usao");
            } else if(elementi instanceof Veza){
                Veza v=(Veza)elementi;
                v.setParent(map);
                treeMap.add(new MapTreeItem(v));
                v.setSubsribers(new ArrayList<>());
                System.out.println("usao veza");
            }
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
