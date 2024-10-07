package gerumap.app.gui.state.concrete;

import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.MindMapView;
import gerumap.app.repository.view.observer.ISubscriber;

public class SelectState extends State {



    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv= MainFrame.getInstance().getProjectView().getCurrentMindMapView();

        for(ElementPainter ep: mmv.getPainteri()){
                if (ep instanceof PojamPainter) {
                    if(((PojamPainter) ep).elementAt(x,y)) {
                        Pojam p = ((PojamPainter) ep).getP();
                        MainFrame.getInstance().getProjectView().getCurrentMindMapView()
                                .getMapSelectionModel().addSelectedChild(p);
                    }
                } else if (ep instanceof VezaPainter) {
                    if (((VezaPainter) ep).getClickedLine(x, y)) {
                        Veza v = ((VezaPainter) ep).getV();
                        MainFrame.getInstance().getProjectView().getCurrentMindMapView()
                                .getMapSelectionModel().addSelectedChild(v);
                    }
                }
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }

}
