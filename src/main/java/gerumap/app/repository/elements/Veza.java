package gerumap.app.repository.elements;

import gerumap.app.repository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Veza extends Element {
    public static int redniBroj=1;
    private Pojam pojamPocetak;
    private Pojam pojamKraj;

    public Veza(int color, int stroke,Pojam pojamPocetak,Pojam pojamKraj) {
        super();
        this.color = color;
        this.stroke = stroke;
        this.pojamPocetak = pojamPocetak;
        this.pojamKraj = pojamKraj;
        this.name = "Veza" + redniBroj++;
    }

    public int[] najblizeSredine(){
        int[] rez={1,1,1,1};
        double min= Integer.MAX_VALUE;

        int x1= pojamPocetak.getX()+ pojamPocetak.getWidth()/2;
        int y1=pojamPocetak.getY();
        int x2=pojamKraj.getX()+ pojamKraj.getWidth()/2;
        int y2=pojamKraj.getY();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX();
        y2=pojamKraj.getY() + pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth();
        y2= pojamKraj.getY()+ pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth()/2;
        y2=pojamKraj.getY() + pojamKraj.getHeight();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x1=pojamPocetak.getX();
        y1=pojamPocetak.getY() + pojamPocetak.getHeight()/2;
        x2=pojamKraj.getX()+ pojamKraj.getWidth()/2;
        y2=pojamKraj.getY();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX();
        y2=pojamKraj.getY() + pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth();
        y2= pojamKraj.getY()+ pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth()/2;
        y2=pojamKraj.getY() + pojamKraj.getHeight();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x1=pojamPocetak.getX() + pojamPocetak.getWidth();
        y1=pojamPocetak.getY() + pojamPocetak.getHeight()/2;
        x2=pojamKraj.getX()+ pojamKraj.getWidth()/2;
        y2=pojamKraj.getY();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX();
        y2=pojamKraj.getY() + pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth();
        y2= pojamKraj.getY()+ pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth()/2;
        y2=pojamKraj.getY() + pojamKraj.getHeight();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x1=pojamPocetak.getX() + pojamPocetak.getWidth()/2;
        y1=pojamPocetak.getY() + pojamPocetak.getHeight();
        x2=pojamKraj.getX()+ pojamKraj.getWidth()/2;
        y2=pojamKraj.getY();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX();
        y2=pojamKraj.getY() + pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth();
        y2= pojamKraj.getY()+ pojamKraj.getHeight()/2;

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        x2=pojamKraj.getX() + pojamKraj.getWidth()/2;
        y2=pojamKraj.getY() + pojamKraj.getHeight();

        if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))<min){
            rez[0]=x1;
            rez[1]=y1;
            rez[2]=x2;
            rez[3]=y2;
            min=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }

        return rez;
    }

}
