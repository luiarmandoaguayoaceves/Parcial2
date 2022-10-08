package _07Practica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Circunferencia extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public Circunferencia() {
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
        circuloPolares(110, 110, 50, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void circuloPolares(int xc, int yc, int r, BufferedImage bu) {

        for (int i = (xc - r); i <= xc + r; i++) {
            float y = yc + (float) Math.sqrt(r * r - Math.pow((i - xc), 2));
            float yar = yc - (float) Math.sqrt(r * r - Math.pow((i - xc), 2));
            bu.setRGB(i, (int) y, Color.BLACK.getRGB());
            bu.setRGB(i, (int) yar, Color.BLACK.getRGB());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Circunferencia as = new Circunferencia();
        as.setVisible(true);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}