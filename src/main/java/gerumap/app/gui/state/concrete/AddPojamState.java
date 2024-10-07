package gerumap.app.gui.state.concrete;

import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.MindMapView;
import gerumap.app.repository.view.observer.ISubscriber;

import java.awt.*;

public class AddPojamState extends State {
//MainFrame.getInstance().getActionManager().getColorAction().getColor().getRGB()
    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        Pojam p = new Pojam(0x000000,2,x,y,100,100);
        p.setParent(mindMap);
        MindMapView mmv=MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        boolean contains=false;
        for(ElementPainter ep: mmv.getPainteri()){
            if (ep instanceof PojamPainter) {
                PojamPainter pp = (PojamPainter) ep;
                if(pp.elementAt(p))
                    contains=true;
            }
        }
        if(!contains){
            mindMap.addChild(p);
            MainFrame.getInstance().getMapTree().addChild(MainFrame.getInstance().getMapTree().getSelectedNode(), p);
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }

}
