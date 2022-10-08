package _06Practica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Rectangulo extends JFrame {

    /**
     * @param args the command line arguments
     */
    private BufferedImage fondo;

    public Rectangulo() {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPanatalla = miPantalla.getScreenSize();
        int altoPantalla = tamanioPanatalla.height;
        int anchoPantalla = tamanioPanatalla.width;

        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);

        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (fondo == null) {
            Graphics graPixel = null;
            fondo = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            graPixel = fondo.getGraphics();
            graPixel.setColor(Color.green);
            graPixel.fillRect(0, 0, getWidth(), getHeight());

            dibujarRectangulo(50, 100, 60, 30, fondo);

            g.drawImage(fondo, 0, 0, null);
        } else {
            g.drawImage(fondo, 0, 0, null);
        }
    }

    public void lineaBresenham(int x0, int y0, int x1, int y1, BufferedImage bu) {
        Color c = Color.red;
        int x = 0, y = 0;
        int dX = 0, dY = 0, p = 0;
        int incE = 0, incNE = 0, stepsX = 0, stepsY = 0;

        dX = (x1 - x0);
        dY = (y1 - y0);

        if (dY < 0) {
            dY = -dY;
            stepsY = -1;
        } else {
            stepsY = 1;
        }
        if (dX < 0) {
            dX = -dX;
            stepsX = -1;
        } else {
            stepsX = 1;
            x = x0;
            y = y0;
            bu.setRGB(x, y, c.getRGB());
        }

        if (dX > dY) {
            p = 2 * dY - dX;
            incE = 2 * dY;
            incNE = 2 * (dY - dX);
            while (x != x1) {
                x = x + stepsX;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepsY;
                    p = p + incNE;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        } else {
            p = 2 * dX - dY;
            incE = 2 * dX;
            incNE = 2 * (dX - dY);
            while (y != y1) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepsX;
                    p = p + incNE;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void dibujarRectangulo(int x, int y, int ancho, int largo, BufferedImage lienzo) {
        lineaBresenham(x, y, x + ancho, y, lienzo);
        lineaBresenham(x, y + largo, x + ancho, y + largo, lienzo);
        lineaBresenham(x, y, x, y + largo, lienzo);
        lineaBresenham(x + ancho, y, x + ancho, y + largo, lienzo);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Rectangulo as = new Rectangulo();
        as.setVisible(true);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}