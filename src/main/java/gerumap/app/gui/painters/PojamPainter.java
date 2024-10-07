package gerumap.app.gui.painters;

import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.GeneralPath;

@Getter
@Setter
public class PojamPainter extends ElementPainter{

    private Pojam p;
    private Shape s;

    public PojamPainter(Pojam p) {
        this.p=p;
    }

    @Override
    public void paint(Graphics2D g, Element element) {
        Pojam p = (Pojam) element;
        g.setColor(new Color(element.getColor()));
        g.setStroke(new BasicStroke(element.getStroke()));
        g.drawString(element.getName(),((Pojam) element).getX()+30,((Pojam) element).getY()+50);

        s = new GeneralPath();
        ((GeneralPath)s).moveTo(p.getX(),p.getY());

        ((GeneralPath)s).lineTo(p.getX()+p.getWidth(),p.getY());

        ((GeneralPath)s).lineTo(p.getX()+p.getWidth(),p.getY()+p.getHeight());

        ((GeneralPath)s).lineTo(p.getX(),p.getY()+p.getHeight());

        ((GeneralPath)s).closePath();

        g.draw(s);
    }

    @Override
    public boolean elementAt(Pojam pojam) {
        return getS().contains(new Point(pojam.getX(),pojam.getY()));
    }

    public boolean elementAt(int x,int y){
        return getS().contains(x,y);
    }

}
