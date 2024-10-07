package gerumap.app.repository.elements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MapElement {

    private int color;
    private int stroke;

    public MapElement(int color, int stroke) {
        this.color = color;
        this.stroke = stroke;
    }
}
