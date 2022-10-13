package _Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Graphics2 {
    private BufferedImage buffer;
    private JFrame parent;

    public Graphics2(JFrame parent){
        this.parent = parent;
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
    }
    public void Pixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        parent.getGraphics().drawImage(buffer, x, y, parent);
    }

    public void animacion(int xc, int yc, int r, int Grosor, Color c)
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
    public void lineaBresenham(int Xo, int Yo, int Xf, int Yf, BufferedImage bu) {//metodo con parametros
        Color c = Color.black;//color
        int x = 0, y = 0, dX, dY, p, incE, incNE, stepsX, stepsY;//variables

        dX = (Xf - Xo);//diferencia de cordenadas X
        dY = (Yf - Yo);//Diferencia de cordenadas y

        if (dY < 0) {//si conrdenada y es menor a 0
            dY = -dY;//cambiar el signo
            stepsY = -1;//iguala a -1
        } else {
            stepsY = 1;//iguala a 1
        }
        if (dX < 0) {//si coordenada X es negativo
            dX = -dX;//cambiar signo
            stepsX = -1;//igualar a -1
        } else {
            stepsX = 1;//igualado a 1
            x = Xo;//asignar vaalor
            y = Yo;//asignar valor
            bu.setRGB(x, y, c.getRGB());//imprimir pixel
        }
        if (dX > dY) {//200 > 0
            p = 2 * dY - dX;// 2 * 0 - 200 = -200
            incE = 2 * dY;//2 * 0 =0
            incNE = 2 * (dY - dX);//2 * (0 - 200) = -400
            while (x != Xf) {//mientras x != 200
                x = x + stepsX;//0 + 1
                if (p < 0) {//-200 < 0
                    p = p + incE;//-200+0
                } else {
                    y = y + stepsY; //100 + 1
                    p = p + incNE;//-200 -400
                }
                bu.setRGB(x, y, c.getRGB()); //pinta
            }
        } else {
            p = 2 * dX - dY;
            incE = 2 * dX;
            incNE = 2 * (dX - dY);
            while (Yo != Yf) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepsX;
                    p = p + incNE;
                }
            }
            bu.setRGB(x, y, c.getRGB());
        }

    }
}
