package gerumap.app.gui.state.concrete;

import gerumap.app.core.ApplicationFramework;
import gerumap.app.gui.dialog.EditStateDialog;
import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.gui.state.State;
import gerumap.app.gui.view.MainFrame;
import gerumap.app.messageGenerator.Event;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.view.MindMapView;

public class EditState extends State {

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv= MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        Element selected=null;
        for(ElementPainter ep: mmv.getPainteri()){
            if (ep instanceof PojamPainter) {
                if(((PojamPainter) ep).elementAt(x,y)) {
                    EditStateDialog editStateDialog = new EditStateDialog();
                    editStateDialog.setVisible(true);
                    ((PojamPainter) ep).getP().setName(editStateDialog.getName());
                    selected = ((PojamPainter) ep).getP();
                }
            } else if (ep instanceof VezaPainter) {
                if (((VezaPainter) ep).getClickedLine(x, y)) {
                    EditStateDialog editStateDialog = new EditStateDialog();
                    editStateDialog.setVisible(true);
                    ((VezaPainter) ep).getV().setName(editStateDialog.getName());
                    selected = ((VezaPainter) ep).getV();
                }
            }
        }
        if(selected!=null) {
            selected.addSubscriber(MainFrame.getInstance().getProjectView().getCurrentMindMapView());
            selected.notifySubscribers(selected, "move");
            Project parent=(Project) mindMap.getParent();
            parent.setChanged(true);
        } else{
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NO_ELEMENT_AT_CLICKED_POINT);
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {

    }

}
