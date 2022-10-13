package _10Practica;
//algoritmo de punto medio para circunferencia
        import java.awt.Graphics;
        import java.awt.image.BufferedImage;
        import javax.swing.JFrame;
        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Toolkit;

public class puntoCircunferencia extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public puntoCircunferencia() {
        setSize(400,400);
        setLocation(100,100);
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

    public  void dibujarCirculoPuntoMedio(int xc, int yc, int r, BufferedImage buff){
        int x, y, p;
        x = 0;
        y = r;
        p = 1 - r;

        while (x < y){
            x = x + 1;
            if (p < 0){
                p = p + 2*x + 1;
                //pinta xk+1,yk
            }
            else if(p > 0){
                y = y - 1;
                p = p + 2*(x - y) + 1;
                //xk+1,yk-1
            }

            buff.setRGB(xc + x,yc + y, Color.black.getRGB());
            buff.setRGB(xc + x,yc - y, Color.black.getRGB());
            buff.setRGB(xc - x,yc + y, Color.black.getRGB());
            buff.setRGB(xc - x,yc - y, Color.black.getRGB());

            buff.setRGB(xc + y, yc + x, Color.black.getRGB());
            buff.setRGB(xc - y, yc + x, Color.black.getRGB());
            buff.setRGB(xc + y, yc - x, Color.black.getRGB());
            buff.setRGB(xc - y, yc - x, Color.black.getRGB());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        puntoCircunferencia asdA = new puntoCircunferencia();
        asdA.setVisible(true);
        asdA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}