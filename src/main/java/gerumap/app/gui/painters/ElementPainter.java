package gerumap.app.gui.painters;

import gerumap.app.repository.elements.MapElement;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter {

    public abstract void paint(Graphics2D g, Element element);

    public abstract boolean elementAt(Pojam pojam);
}
