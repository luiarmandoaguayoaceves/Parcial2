package _06Practica;
//rectangulo
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Rectangulo extends JFrame {

    private BufferedImage fondo;

    public Rectangulo() {
        setSize(400,400);
        setLocation(100,100);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (fondo == null) {
            Graphics graPixel = null;
            fondo = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            graPixel = fondo.getGraphics();
            graPixel.setColor(Color.black);
            graPixel.fillRect(0, 0, getWidth(), getHeight());
            Rectangulo(200, 200, 60, 30, fondo);
            g.drawImage(fondo, 0, 0, null);
        } else {
            g.drawImage(fondo, 0, 0, null);
        }
    }

    public void Bresenham(int x0, int y0, int x1, int y1, BufferedImage bu) {
        Color c = Color.white;
        int x = 0, y = 0;
        int dX = 0, dY = 0, p = 0;
        int iE = 0, iN = 0, stepsX = 0, stepsY = 0;

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
            iE = 2 * dY;
            iN = 2 * (dY - dX);
            while (x != x1) {
                x = x + stepsX;
                if (p < 0) {
                    p = p + iE;
                } else {
                    y = y + stepsY;
                    p = p + iN;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        } else {
            p = 2 * dX - dY;
            iE = 2 * dX;
            iN = 2 * (dX - dY);
            while (y != y1) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + iE;
                } else {
                    x = x + stepsX;
                    p = p + iN;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void Rectangulo(int x, int y, int ancho, int largo, BufferedImage lienzo) {
        Bresenham(x, y, x + ancho, y, lienzo);
        Bresenham(x, y + largo, x + ancho, y + largo, lienzo);
        Bresenham(x, y, x, y + largo, lienzo);
        Bresenham(x + ancho, y, x + ancho, y + largo, lienzo);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Rectangulo as = new Rectangulo();
        as.setVisible(true);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}