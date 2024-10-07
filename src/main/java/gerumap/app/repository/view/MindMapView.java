package gerumap.app.repository.view;
import gerumap.app.gui.painters.ElementPainter;
import gerumap.app.gui.painters.PojamPainter;
import gerumap.app.gui.painters.VezaPainter;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.MapSelectionModel;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.view.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {
    private MindMap mindMap;
    private MapSelectionModel mapSelectionModel = new MapSelectionModel();
    private ProjectView parent;
    private List<ElementPainter> painteri=new ArrayList<>();
    private Framework framework;
    int i =0;


    public MindMapView(MindMap mindMap,ProjectView parent) {
        this.mindMap = mindMap;
        this.parent=parent;
        mindMap.addSubscriber(this);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        framework=new Framework();
        framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
        framework.setBackground(Color.WHITE);
        this.add(framework,BorderLayout.CENTER);
        this.addMouseListener(new MouseController());
        this.addMouseMotionListener(new MouseController());
        this.mapSelectionModel.addSubscriber(this);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Pojam){
            PojamPainter pp=new PojamPainter((Pojam)notification);
            painteri.add(pp);
            repaint();
        }
    }
    @Override
    public void update(Object notification, String type) {
        if (notification instanceof MindMap) {
            parent.getMindMapViews().remove(this);
            parent.getJTabbedPane().remove(this);
            parent.getProject().getChildren().remove(this.mindMap);
        }
        if(type=="add") {
            if (notification instanceof Pojam) {
                PojamPainter pp = new PojamPainter((Pojam) notification);
                painteri.add(pp);
            } else if (notification instanceof Veza) {
                VezaPainter vp = new VezaPainter((Veza) notification);
                painteri.add(vp);
            }
        }

        if(type=="delete") {
            if (notification instanceof Pojam) {
                PojamPainter selected = null;
                for (ElementPainter ep : painteri) {
                    if (ep instanceof PojamPainter) {
                        PojamPainter pp = (PojamPainter) ep;
                        Pojam p = (Pojam) notification;
                        if (pp.getP() == p) {
                            selected = pp;
                        }

                    }
                }
                painteri.remove(selected);
                Iterator<Veza> iterator = selected.getP().getVeze().listIterator();
                while (iterator.hasNext()) {
                    Veza v = iterator.next();
                    Iterator<ElementPainter> epIterator = painteri.listIterator();
                    while (epIterator.hasNext()) {
                        ElementPainter ep = epIterator.next();
                        if (ep instanceof VezaPainter && ((VezaPainter) ep).getV() == v) {
                            epIterator.remove();
                        }
                    }
                    iterator.remove();
                }

            }else if(notification instanceof Veza){
                VezaPainter selectedV = null;
                for (ElementPainter ep : painteri) {
                    if (ep instanceof VezaPainter) {
                        VezaPainter vp = (VezaPainter) ep;
                        Veza v = (Veza) notification;
                        if (vp.getV() == v) {
                            selectedV = vp;
                        }
                    }
                }
                painteri.remove(selectedV);
                selectedV.getV().getPojamPocetak().getVeze().remove(selectedV.getV());
                selectedV.getV().getPojamKraj().getVeze().remove(selectedV.getV());
            }
        }

        if(type=="move"){
            for (ElementPainter ep : painteri) {
                if (ep instanceof PojamPainter) {
                    PojamPainter pp = (PojamPainter) ep;
                    Pojam p = (Pojam) notification;
                    if (pp.getP() == p) {
                        pp.setP(p);
                    }

                }
            }
        }

        repaint();
    }

    private class MouseController extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            parent.misKliknut(e.getX(),e.getY(),mindMap);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            parent.misOtpusten(e.getX(),e.getY(),mindMap);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            parent.misPovucen(e.getX(),e.getY(),mindMap);
        }
    }
    private class Framework extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (ElementPainter p : painteri) {
                g.setColor(Color.black);
                if (p instanceof PojamPainter) {
                    PojamPainter pp = (PojamPainter) p;
                    if (mapSelectionModel.getSelectedElements().contains(((PojamPainter) p).getP())){
                        g2.setColor(Color.RED);
                        ((PojamPainter) p).getP().setColor(0x2596be);
                    }
                    p.paint(g2, pp.getP());
                }
                if (p instanceof VezaPainter) {
                    VezaPainter vp = (VezaPainter) p;
                    p.paint(g2, vp.getV());
                }
            }
        }
    }
}