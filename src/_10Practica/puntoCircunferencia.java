package _10Practica;

        import java.awt.Graphics;
        import java.awt.image.BufferedImage;
        import javax.swing.JFrame;
        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Toolkit;
/**
 *
 * @author lalo_
 */
public class puntoCircunferencia extends JFrame {

    /**
     * @param args the command line arguments
     */
    private BufferedImage buffer;
    private Graphics graPixel;

    public puntoCircunferencia() {
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
        dibujarCirculoPuntoMedio(200, 290, 50, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public  void dibujarCirculoPuntoMedio(int xc, int yc, int r, BufferedImage lienzo){
        int x, y, p;
        x = 0;
        y = r;
        p = 1 - r;

        while (x < y){
            x = x + 1;
            if (p < 0){
                p = p + 2*x + 1;
            }
            else {
                y = y - 1;
                p = p + 2*(x - y) + 1;

            }

            lienzo.setRGB(xc + x,yc + y, Color.green.getRGB());
            lienzo.setRGB(xc + x,yc - y, Color.green.getRGB());
            lienzo.setRGB(xc - x,yc + y, Color.green.getRGB());
            lienzo.setRGB(xc - x,yc - y, Color.green.getRGB());

            lienzo.setRGB(xc + y, yc + x, Color.green.getRGB());
            lienzo.setRGB(xc - y, yc + x, Color.green.getRGB());
            lienzo.setRGB(xc + y, yc - x, Color.green.getRGB());
            lienzo.setRGB(xc - y, yc - x, Color.green.getRGB());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        puntoCircunferencia asdA = new puntoCircunferencia();
        asdA.setVisible(true);
        asdA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}