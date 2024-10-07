package gerumap.app.gui.painters;

import gerumap.app.repository.elements.MapElement;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.*;

@Getter
@Setter
public class VezaPainter extends ElementPainter {
    private static final int HIT_BOX_SIZE = 2;
    private Veza v;
    private Shape s;

    @Override
    public void paint(Graphics2D g, Element element) {
        //Veza v = (Veza) element;
        g.setColor(new Color(element.getColor()));
        g.setStroke(new BasicStroke(element.getStroke()));

        int[] tacke = v.najblizeSredine();
        /**    s = new GeneralPath();
         ((GeneralPath)s).moveTo(tacke[0],tacke[1]);
         ((GeneralPath)s).lineTo(tacke[2],tacke[3]);
         ((GeneralPath)s).closePath();
         g.draw(s);*/

        s = new Line2D.Double(tacke[0], tacke[1], tacke[2], tacke[3]);
        g.draw(s);
    }

    public VezaPainter(Veza veza) {
        this.v = veza;
    }

    @Override
    public boolean elementAt(Pojam pojam) {
        return false;
    }


    public boolean getClickedLine(int x, int y) {
        int boxX = x - HIT_BOX_SIZE / 2;
        int boxY = y - HIT_BOX_SIZE / 2;

        int width = HIT_BOX_SIZE;
        int height = HIT_BOX_SIZE;

        boolean kliknut = false;
        if (s.intersects(boxX, boxY, width, height)){
            kliknut = true;
        }

        return kliknut;
    }
}
