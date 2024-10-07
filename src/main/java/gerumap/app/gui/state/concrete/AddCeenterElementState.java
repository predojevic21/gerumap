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
import gerumap.app.repository.implementation.Project;
import gerumap.app.repository.view.MindMapView;

public class AddCeenterElementState extends State {
    Pojam centar;

    @Override
    public void misKliknut(int x, int y, MindMap mindMap) {
        MindMapView mmv = MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        for (ElementPainter p : mmv.getPainteri()) {
            if (p instanceof PojamPainter) {
                if (((PojamPainter) p).elementAt(x, y)) {
                    centar = ((PojamPainter) p).getP();
                    break;
                }
            }
        }
        if (centar == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(Event.NO_ELEMENT_AT_CLICKED_POINT);
        }
    }

    @Override
    public void misPovucen(int x, int y, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(int x, int y, MindMap mindMap) {
        int sirina = MainFrame.getInstance().getDesniPanel().getWidth();
        int visina = MainFrame.getInstance().getDesniPanel().getHeight();
        MindMapView mmv = MainFrame.getInstance().getProjectView().getCurrentMindMapView();
        int povecajX = 0;
        int povecajY = 0;
        int flag = 0;
        int flag2 = 0;
        for (ElementPainter p : mmv.getPainteri()) {
            if (p instanceof PojamPainter) {
                if (((PojamPainter) p).getP() == centar) {
                    centar.setX(sirina / 3);
                    centar.setY(visina / 3);
                    centar.setColor(0x36e236);
                    centar.setStroke(5);
                }
            }
        }

        for (ElementPainter p : mmv.getPainteri()) {
            if (p instanceof PojamPainter) {
                if (((PojamPainter) p).getP() != centar) {
                    if (povecajX < 440 && povecajY == 0) {
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajX += 110;
                    } else if (povecajX == 440 && povecajY < 330) {
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajY += 110;
                    } else if (povecajX == 440 && povecajY == 330) {
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajX -= 110;
                        flag = 1;
                    }else if (povecajX < 440 && povecajY == 330 && flag == 1) {
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajX -= 110;
                        System.out.println("x " + povecajX);
                    }else if(povecajX == 0 && povecajY== 330){
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajY -= 110;
                        flag2 = 1;
                    }else if(povecajX < 0 && povecajY < 330 && flag2==1){
                        ((PojamPainter) p).getP().setX(10 + povecajX);
                        ((PojamPainter) p).getP().setY(10 + povecajY);
                        povecajY -= 110;
                    }
                }
            }
        }

        centar.addSubscriber(MainFrame.getInstance().getProjectView().getCurrentMindMapView());
        centar.notifySubscribers(centar, "centar");
        Project parent=(Project) mindMap.getParent();
        parent.setChanged(true);
        centar = null;
    }
}
