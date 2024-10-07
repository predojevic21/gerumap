package gerumap.app.gui.state.concrete;

import gerumap.app.core.ApplicationFramework;
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
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ColorState extends State {
    Color color = Color.BLACK;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv = MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        Element selected = null;
        for (ElementPainter ep : mmv.getPainteri()) {
            if (ep instanceof PojamPainter) {
                if (((PojamPainter) ep).elementAt(x, y)) {
                    Color initialcolor = Color.BLACK;
                    color = JColorChooser.showDialog(MainFrame.getInstance().getDesniPanel(), "Select a color", initialcolor);
                    ((PojamPainter) ep).getP().setColor(color.getRGB());
                    selected = ((PojamPainter) ep).getP();
                }
            } else if (ep instanceof VezaPainter) {
                if (((VezaPainter) ep).getClickedLine(x, y)) {
                    Color initialcolor = Color.BLACK;
                    color = JColorChooser.showDialog(MainFrame.getInstance().getDesniPanel(), "Select a color", initialcolor);
                    ((VezaPainter) ep).getV().setColor(color.getRGB());
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
