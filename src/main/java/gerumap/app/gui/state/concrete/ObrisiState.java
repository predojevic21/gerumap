package gerumap.app.gui.state.concrete;

import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.MindMapView;

public class ObrisiState extends State {


    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv= MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        Element selected=null;
        for(ElementPainter p:mmv.getPainteri()) {
            if (p instanceof PojamPainter) {
                if (((PojamPainter) p).elementAt(x, y)) {
                    selected=((PojamPainter) p).getP();
                }
            }else if(p instanceof VezaPainter){
                if(((VezaPainter) p).getClickedLine(x, y)){
                    selected = ((VezaPainter) p).getV();
                }
            }
        }
        mindMap.removeChild(selected);
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {
    }
    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {
    }
}