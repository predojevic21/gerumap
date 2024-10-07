package gerumap.app.gui.state.concrete;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.view.MindMapView;
import gerumap.app.repository.view.observer.ISubscriber;

public class MoveState extends State {
    Pojam pocetni;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv= MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        for(ElementPainter p:mmv.getPainteri()){
            if(p instanceof PojamPainter){
                if(((PojamPainter) p).elementAt(x,y)){
                    pocetni=((PojamPainter) p).getP();
                    break;
                }
            }
        }
        if(pocetni==null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NO_ELEMENT_AT_CLICKED_POINT);
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {
        if(pocetni!=null){
           pocetni.setX(x);
           pocetni.setY(y);
           pocetni.addSubscriber(MainFrame.getInstance().getProjectView().getCurrentMindMapView());
           pocetni.notifySubscribers(pocetni,"move");
            Project parent=(Project) mindMap.getParent();
            parent.setChanged(true);
        }
        pocetni=null;
    }



}
