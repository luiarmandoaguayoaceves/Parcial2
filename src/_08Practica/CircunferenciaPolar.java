package _08Practica;
//circunferencia coordfenada polares
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CircunferenciaPolar extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;

    public CircunferenciaPolar() {
        setSize(400,400);
        setLocation(100,100);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        circuloPolares(200, 200, 50, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void circuloPolares(int xc, int yc, int r, BufferedImage bu) {

        int x, y;
        float t = 0;
        Graphics cir = bu.getGraphics();
        cir.setColor(Color.BLACK);

        for (int i = 0; i < 360; i++) {
            x = (int) (xc + r * Math.cos(Math.toRadians(i)));
            y = (int) (yc + r * Math.sin(Math.toRadians(i)));
            bu.setRGB(x, y, Color.black.getRGB());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        CircunferenciaPolar as = new CircunferenciaPolar();
        as.setVisible(true);
        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}