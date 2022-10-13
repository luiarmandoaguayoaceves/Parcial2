package _11Practica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
/**
 *
 * @author lalo_
 */
public class circunferenciaBresenham extends JFrame {

    /**
     * @param args the command line arguments
     */
    private BufferedImage buffer;
    private Graphics graPixel;

    public circunferenciaBresenham() {
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
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        circuloBrensenham(200, 250, 130, buffer);
        circuloBrensenham(200, 200, 130, buffer);
        g.drawImage(buffer, 0, 0, null);
    }

    public void circuloBrensenham(int xc, int yc, int r, BufferedImage buff) {
        int x = - r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            buff.setRGB(xc - x, yc + y, Color.blue.getRGB());
            buff.setRGB(xc - y, yc - x, Color.blue.getRGB());
            buff.setRGB(xc + x, yc - y, Color.blue.getRGB());
            buff.setRGB(xc + y, yc + x, Color.blue.getRGB());

            r = error;
            if (r > x) {
                error += ++x * 2 + 1;
            }
            if (r <= y) {
                error += ++y * 2 + 1;
            }
        } while (x < 0);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        circunferenciaBresenham as = new circunferenciaBresenham();
        as.setVisible(true);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}