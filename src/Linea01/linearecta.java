package Linea01;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class linearecta extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    public linearecta() {
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
        as(0, 50, buffer);
        g.drawImage(buffer, 0, 0, null);
    }

    public void as(int x, int y, BufferedImage buffer) {
        Color c = Color.black;
        for (int i = 0; i < 200; i++) {
            buffer.setRGB(x + i, y, c.getRGB());
        }
    }
    public static void main(String[] args) {
        linearecta a = new linearecta();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }

}