package pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Ventana extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;
    public Ventana() {
        buffer = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
        putPixel(0,0, Color.black);
    }
    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}