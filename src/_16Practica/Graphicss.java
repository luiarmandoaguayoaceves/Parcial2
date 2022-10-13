package _16Practica;
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

    public void BresenhamCirculoGrosor(int xc, int yc, int r, int Grosor, Color c)
    {
        int x = -r;
        int y = 0;
        int err = 2-2*r;

        do {
            for(int i = Grosor - 1; i > 0; i--) {

                Pixel(xc - x, yc + y, c); //abajo hacia derecha
                Pixel(xc - x-i, yc + y, c); //abajo hacia derecha
                Pixel(xc - x+i, yc + y, c); //abajo hacia derecha
                Pixel(xc - x, yc + y-i, c); //abajo hacia derecha
                Pixel(xc - x, yc + y+i, c); //abajo hacia derecha

                Pixel(xc - y, yc - x, c); //abajo hacia izquierda
                Pixel(xc - y-i, yc - x, c); //abajo hacia izquierda
                Pixel(xc - y+i, yc - x, c); //abajo hacia izquierda
                Pixel(xc - y, yc - x-i, c); //abajo hacia izquierda
                Pixel(xc - y, yc - x+i, c); //abajo hacia izquierda

                Pixel(xc + x, yc - y, c); //arriba hacia la izquierda
                Pixel(xc + x+i, yc - y, c); //arriba hacia la izquierda
                Pixel(xc + x-i, yc - y, c); //arriba hacia la izquierda
                Pixel(xc + x, yc - y+i, c); //arriba hacia la izquierda
                Pixel(xc + x, yc - y-i, c); //arriba hacia la izquierda

                Pixel(xc + y, yc + x, c); //arriba hacia la derecha
                Pixel(xc + y+i, yc + x, c); //arriba hacia la derecha
                Pixel(xc + y-i, yc + x, c); //arriba hacia la derecha
                Pixel(xc + y, yc + x+i, c); //arriba hacia la derecha
                Pixel(xc + y, yc + x-i, c); //arriba hacia la derecha
            }
            r = err;
            if (r > x)
                err += ++x*2+1; /* e_xy+e_x > 0 */
            if (r <= y)
                err += ++y*2+1; /* e_xy+e_y < 0*/
        } while (x < 0);
    }
}
