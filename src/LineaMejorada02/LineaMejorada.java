package LineaMejorada02;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class LineaMejorada extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    public LineaMejorada() {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPanatalla = miPantalla.getScreenSize();
        int altoPantalla = tamanioPanatalla.height;
        int anchoPantalla = tamanioPanatalla.width;

        setSize(anchoPantalla/2, altoPantalla/2);
        setLocation(anchoPantalla/4, altoPantalla/4);

        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        dibujaLinea(0, 10, 200, 100, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void dibujaLinea(int x0, int y0, int x1, int y1, BufferedImage bu) {

        Color c = Color.black;

        float adyacente = (float) Float.max(x0, x1) - Float.min(x0, x1);
        float opuesto = (float) Float.max(y0, y1) - Float.min(y0, y1);
        float pendiente = (float) opuesto / adyacente;

        int sigX = 0;
        int sigY = 0;
        pendiente = Math.abs(pendiente);

        if (x0 < x1) {
            sigX = 1;
        } else {
            sigX = -1;
        }
        if (y0 < y1) {
            sigY = 1;
        } else {
            sigY = -1;
        }

        if (Math.toDegrees(Math.atan(pendiente)) > 45) {
            pendiente = (float) Math.abs(adyacente / opuesto);
            for (int i = 0; i <= Math.abs(opuesto); i++) {
                bu.setRGB(x0 + (int) (i * pendiente * sigX), y0 + (i * sigY), c.getRGB());
            }
        } else {
            for (int h = 0; h <= Math.abs(adyacente); h++) {
                bu.setRGB(x0 + h * sigX, y0 + (int) (h * pendiente * sigY), c.getRGB());
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        LineaMejorada a = new LineaMejorada();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }

}
