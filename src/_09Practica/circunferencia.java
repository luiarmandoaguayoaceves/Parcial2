package _09Practica;
//simetria de los 8 lados de la circunferencia
        import javax.swing.JFrame;
        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Graphics;
        import java.awt.Toolkit;
        import java.awt.image.BufferedImage;

public class circunferencia extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public circunferencia() {
        setSize(400,400);
        setLocation(100,100);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        circuloPolaresOcho(200, 200, 50, buffer);
        g.drawImage(buffer, 0, 0, null);
    }

    public void circuloPolaresOcho(int xc, int yc, int r, BufferedImage bu) {

        int x, y;
        float t = 0;
        Graphics cir = bu.getGraphics();
        cir.setColor(Color.black);

        for (int i = 0; i < 45; i++) {

            x = (int) (r * Math.cos(Math.toRadians(i)));
            y = (int) (r * Math.sin(Math.toRadians(i)));

            bu.setRGB(xc + x, yc + y, Color.black.getRGB());
            bu.setRGB(xc - x, yc - y, Color.black.getRGB());
            bu.setRGB(xc + x, yc - y, Color.black.getRGB());
            bu.setRGB(xc - x, yc + y, Color.black.getRGB());

            bu.setRGB(yc + y, xc + x, Color.black.getRGB());
            bu.setRGB(yc - y, xc - x, Color.black.getRGB());
            bu.setRGB(yc - y, xc + x, Color.black.getRGB());
            bu.setRGB(yc + y, xc - x, Color.black.getRGB());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        circunferencia oc = new circunferencia();
        oc.setVisible(true);
        oc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
