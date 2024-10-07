package gerumap.app.repository.view;

import gerumap.app.Main;
import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.gui.state.StateManager;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.gui.view.ToolBar2;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.view.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProjectView extends JPanel implements ISubscriber, ChangeListener {

    private JPanel imena;
    private JLabel imeProjekta;
    private JLabel imeAutora;
    private JTabbedPane jTabbedPane;
    private Project project;
    private List<MindMapView> mindMapViews = new ArrayList<>();
    private StateManager stateManager =new StateManager();
    private ToolBar2 toolBar2;
    private MindMapView currentMindMapView;

    //meotda misKliknut koju cemo da pozivamo u MinMapView,
    // treba da kaze this.StateMenadzer.current.misJeKliknut(iz pojam state)


    public ProjectView(Project project) {
        this.project = project;
        project.addSubscriber(this);


        imeProjekta = new JLabel(project.getName());
        imeAutora = new JLabel(project.getAutor());

        imena = new JPanel();
        imena.setLayout(new GridLayout(2,1));
        imena.add(imeProjekta);
        imena.add(imeAutora);

        this.setLayout(new BorderLayout());

        jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(50, 100, 300, 300);

        this.add(jTabbedPane,BorderLayout.CENTER);
        this.add(imena,BorderLayout.NORTH);

        toolBar2 = new ToolBar2();

        this.add(toolBar2,BorderLayout.EAST);
        jTabbedPane.addChangeListener(this);

    }

    @Override
    public void update(Object notification) {

    }

    @Override
    public void update(Object notification,String type) {
        if(notification instanceof MindMap){
            MindMapView mindMapView = new MindMapView((MindMap) notification,this);
            mindMapViews.add(mindMapView);
            jTabbedPane.add(mindMapView,mindMapView.getMindMap().getName());
            jTabbedPane.updateUI();
            //currentMindMapView=mindMapView;
        }else if(notification instanceof Project) {
            if (type.equals("delete")) {
                imeProjekta.setText("");
                imeAutora.setText("");
                jTabbedPane.removeAll();
            }
            }else {
            if (type.equals("ime")) {
                imeProjekta.setText((String) notification);
                this.updateUI();
            } else if (type.equals("autor")) {
                imeAutora.setText((String) notification);
                this.updateUI();
            }
            }
    }


    public void setProject(Project project) {
        if (this.project != project) {
            if (this.project != null) {
                this.project.removeSubscriber(this);
            }
            this.project = project;
            jTabbedPane.removeAll();
            this.imeProjekta.setText(project.getName());
            imeAutora.setText(project.getAutor());

            if (project != null) {
                project.addSubscriber(this);
                for (int i = 0; i < project.getChildren().size(); i++) {
                    project.getChildren().get(i).setSubsribers(new ArrayList<>()); 
                    MindMapView mmv = new MindMapView((MindMap) project.getChildren().get(i),this);
                    MindMap mm=(MindMap) project.getChildren().get(i);
                for(int j=0;j < mm.getChildren().size();j++){
                   Element e= (Element) mm.getChildren().get(j);
                   if(e instanceof Pojam){
                       PojamPainter pp=new PojamPainter((Pojam)e);
                       mmv.getPainteri().add(pp);
                   }else if(e instanceof Veza){
                       VezaPainter vp=new VezaPainter((Veza)e);
                       mmv.getPainteri().add(vp);
                   }
                }
                    jTabbedPane.addTab(mmv.getMindMap().getName(), mmv);
                    jTabbedPane.updateUI();

                }
            }
            this.updateUI();
        }
    }

    public void startAddPojamState(){this.stateManager.setAddPojamState();}
    public void startAddVezaState(){
        this.stateManager.setAddVezaState();
    }
    public void startMovestate(){
        this.stateManager.setMoveState();
    }
    public void startObrisistate(){this.stateManager.setObrisiState();}
    public void startSelectstate(){ this.stateManager.setSelectState(); }
    public void startEditState(){
        this.stateManager.setEditState();
    }
    public void startColorState() {
        this.stateManager.setColorState();
    }
    public void startAddCeenterElementState() {
        this.stateManager.setAddCeenterElementState();
    }


    public void misKliknut(int x, int y, MindMap mindMap){
        this.stateManager.getCurrent().misKliknut(x,y,mindMap);
    }
    public void misPovucen(int x, int y, MindMap mindMap){
        this.stateManager.getCurrent().misPovucen(x,y,mindMap);
    }
    public void misOtpusten(int x, int y, MindMap mindMap){this.stateManager.getCurrent().misOtpusten(x,y,mindMap);}

    @Override
    public void stateChanged(ChangeEvent e) {
        currentMindMapView= (MindMapView) jTabbedPane.getSelectedComponent();
    }
}
