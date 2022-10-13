package _01Practica;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class linearecta extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;

    public linearecta() {
        setSize(400,400);
        setLocation(100,100);

        setLayout(null);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);//crear el buffer parametro de alto, ancho y tipo de buffer ARGB
        graPixel = buffer.createGraphics();//pixel
        linea(100, 250, buffer);//metodo Linea
        g.drawImage(buffer, 0, 0, null);//imagen se le pasa buffer  x y y
    }
    public void linea(int m, int b, BufferedImage buffer) {
        Color c = Color.black;//color del pixel
        for (int x = 0; x < 200; x++) {//ciclo for para pintar pixel por la coprdenada x
            buffer.setRGB(m + x, b, c.getRGB());//vaciar bufer (pixel)
        }
    }
    public static void main(String[] args) {
        linearecta linea = new linearecta();//crea objeto de tipo linea recta
        linea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        linea.setVisible(true);
    }
}