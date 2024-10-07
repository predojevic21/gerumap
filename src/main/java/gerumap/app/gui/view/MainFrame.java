package gerumap.app.gui.view;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.controller.ActionManager;
import gerumap.app.gui.tree.MapTree;
import gerumap.app.gui.tree.MapTreeImplementation;
import gerumap.app.gui.tree.model.MapTreeItem;
import gerumap.app.gui.tree.view.MapTreeView;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.implementation.ProjectExplorer;
import gerumap.app.repository.view.ProjectView;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame{

    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private MapTree mapTree;
    private MapTreeView mapTreeView;
    private ProjectView projectView;
    private JPanel desniPanel;


    private void initialise() {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGUI();
    }

    private void initialiseGUI() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth*3 / 4, screenHeight*3/ 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);

       MapTreeView projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());
       mapTreeView=projectExplorer;

       // JPanel desktop = new JPanel();
        projectView = new ProjectView(new Project("",ApplicationFramework.getInstance().getMapRepository().getProjectExplorer(),""));
        desniPanel = new JPanel();
        desniPanel.setLayout(new BorderLayout());
        desniPanel.add(projectView, BorderLayout.CENTER);
        desniPanel.setMinimumSize(new Dimension(400,400));
        desniPanel.setBackground(Color.blue);
       //desniPanel.add(new JLabel("AAAAAA"));

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desniPanel);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
        //this.add(desniPanel);
    }

    private static MainFrame instance;

    private MainFrame(){

    }

    public static MainFrame getInstance(){
        if(instance==null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

}
