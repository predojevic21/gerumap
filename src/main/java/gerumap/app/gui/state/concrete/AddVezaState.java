package gerumap.app.gui.state.concrete;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.MindMapView;
import gerumap.app.repository.view.observer.ISubscriber;

public class AddVezaState extends State {

    Pojam pocetni;
    Pojam krajni;

    public AddVezaState() {
        //krajni = new Pojam(0x000000,2,35,35,100,100);
    }

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
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {
       // System.out.println("MIS SE VUCE");
        if(mindMap != null){
         //   System.out.println("usao u if");
           // krajni.setX(x);
           // krajni.setY(y);
            //ovde mora i neki observer da se ubaci?
        }
    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {
        MindMapView mmv= MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        Pojam pojam;
        for(ElementPainter p:mmv.getPainteri()){
            if(p instanceof PojamPainter){
                if(((PojamPainter) p).elementAt(x,y)){
                    krajni=((PojamPainter) p).getP();
                    break;
                }
            }
        }
        if(pocetni!=null && krajni!=null && pocetni!=krajni) {
            Veza veza = new Veza(0x000000, 2, pocetni, krajni);
            pocetni.getVeze().add(veza);
            krajni.getVeze().add(veza);
            veza.setParent(mindMap);
            mindMap.addChild(veza);
            MainFrame.getInstance().getMapTree().addChild(MainFrame.getInstance().getMapTree().getSelectedNode(), veza);
        }else{
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NO_ELEMENT_AT_CLICKED_POINT);
        }
        pocetni=null;
        krajni=null;
    }

}
