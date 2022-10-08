package _05Practica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class PuntoMedio extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public PuntoMedio() {
        setSize(400,400);
        setLocation(100,100);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        lineaPuntoMedio(0, 100, 50, 200, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void lineaPuntoMedio(int x0, int y0, int x1, int y1, BufferedImage b) {
        int x, y, dx, dy, xend, p, incE, incNE;
        dx = x1 - x0;
        dy = y1 - y0;
        p = 2 * dy - dx;
        incE = 2 * dy;
        incNE = 2 * (dy - dx);
        /* determinar que punto usar para empezar, cual para terminar */
        if (x0 > x1) {
            x = x1;
            y = y1;
            xend = x0;
        } else {
            x = x0;
            y = y0;
            xend = x1;
        }
        /* se cicla hasta llegar al extremo de la línea */
        while (x <= xend) {
            b.setRGB(x, y, Color.black.getRGB());
            x = x + 1;
            if (p <= 0) {
                p = p + incE;
            } else {
                y = y + 1;
                p = p + incNE;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        PuntoMedio a = new PuntoMedio();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }

}