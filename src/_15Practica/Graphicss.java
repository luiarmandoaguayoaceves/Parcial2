package _15Practica;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author lalo_
 */
public class Graphicss {
    private BufferedImage buffer;
    private JFrame parent;

    public Graphicss(JFrame parent){
        this.parent = parent;
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
    }

    public void Pixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        parent.getGraphics().drawImage(buffer, x, y, parent);
    }

    

    public void PuntoMedioMascara(int x1, int y1, int x2, int y2, int mascara[], Color c) {
        //System.out.println(mascara[0]);
        int pk, A, B, pxlx, pxly;
        int ContadorMascara = 0 ;

        int dx = (x2 - x1);
        int dy = (y2 - y1);

        if (dy < 0) {
            dy = -dy;
            pxly = -1;
        }
        else {
            pxly = 1;
        }
        if (dx < 0) {
            dx = -dx;
            pxlx = -1;
        } else {
            pxlx = 1;
        }

        int X = x1;
        int Y = y1;
        Pixel(x1, y1, c);

        if(dx>dy){
            pk = 2*dy - dx;
            A = 2*dy;
            B = 2*(dy-dx);
            while (X != x2){
                X = X + pxlx;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    Y = Y + pxly + 1/2;
                    pk = pk + B;
                }
                if(mascara[ContadorMascara] == 1)
                    Pixel(X, Y, c);
                ContadorMascara++;
                if(ContadorMascara >= mascara.length)
                    ContadorMascara = 0;
            }
        } else {
            pk = 2*dx - dy;
            A = 2*dx;
            B = 2*(dx-dy);
            while (Y != y2){
                Y = Y + pxly + 1/2;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    X = X + pxlx;
                    pk = pk + B;
                }
                if(mascara[ContadorMascara] == 1)
                    Pixel(X, Y, c);
                ContadorMascara++;
                if(ContadorMascara >= mascara.length)
                    ContadorMascara = 0;
            }
        }
    }

    public void PuntoMedioGrosor(int x1, int y1, int x2, int y2, int Grosor, Color c) {
        int pk, A, B, pxlx, pxly;

        int dx = (x2 - x1);
        int dy = (y2 - y1);

        if (dy < 0) {
            dy = -dy;
            pxly = -1;
        }
        else {
            pxly = 1;
        }
        if (dx < 0) {
            dx = -dx;
            pxlx = -1;
        } else {
            pxlx = 1;
        }

        int X = x1;
        int Y = y1;
        Pixel(x1, y1, c);

        if(dx>dy){
            pk = 2*dy - dx;
            A = 2*dy;
            B = 2*(dy-dx);
            while (X != x2){
                X = X + pxlx;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    Y = Y + pxly + 1/2;
                    pk = pk + B;
                }
                for(int i = Grosor - 1; i > 0; i--) {
                    Pixel(X, Y, c);
                    Pixel(X-i, Y, c);
                    Pixel(X, Y-i, c);
                    Pixel(X, Y+i, c);
                    Pixel(X+i, Y, c);
                }
            }
        } else {
            pk = 2*dx - dy;
            A = 2*dx;
            B = 2*(dx-dy);
            while (Y != y2){
                Y = Y + pxly + 1/2;
                if (pk < 0){
                    pk = pk + A;
                } else {
                    X = X + pxlx;
                    pk = pk + B;
                }
                for(int i = Grosor - 1; i > 0; i--) {
                    Pixel(X, Y, c);
                    Pixel(X-i, Y, c);
                    Pixel(X, Y-i, c);
                    Pixel(X, Y+i, c);
                    Pixel(X+i, Y, c);
                }
            }
        }
    }

    public void BresenhamCirculoMascara(int xc, int yc, int r, int mascara[], Color c){
        int ContadorMascara = 0;
        int x = -r;
        int y = 0;
        int err = 2-2*r;

        do {
            //if(r%2 == 0 && mascara.length%2 == 0){
            if(mascara[ContadorMascara] == 1) {
                Pixel(xc - x, yc + y, c); //abajo hacia derecha
                Pixel(xc - y, yc - x, c); //abajo hacia izquierda
                Pixel(xc + x, yc - y, c); //arriba hacia la izquierda
                Pixel(xc + y, yc + x, c); //arriba hacia la derecha
            }

            r = err;
            if (r > x)
                err += ++x*2+1; /* e_xy+e_x > 0 */
            if (r <= y)
                err += ++y*2+1; /* e_xy+e_y < 0*/

            ContadorMascara++;
            if(ContadorMascara >= mascara.length)
                ContadorMascara = 0;
        } while (x < 0);
    }

}
