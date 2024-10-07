package gerumap.app.repository.elements;

import gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pojam extends Element {
    public static int redniBroj=1;
    private int width;
    private int height;
    private int x;
    private int y;
    private List<Veza> veze = new ArrayList<>();

    public Pojam(int color, int stroke,int x,int y,int width,int height) {
        super();
        this.color = color;
        this.stroke = stroke;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.name="Pojam" + redniBroj++;
    }

}
