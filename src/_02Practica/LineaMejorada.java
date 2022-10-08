package _02Practica;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class LineaMejorada extends JFrame {


    private BufferedImage buffer;
    private Graphics graPixel;

    public LineaMejorada() {
        setSize(400,400);//tamanio de la ventana
        setLocation(100,100);//ubicacion

        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//usar metodos del padre
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);//Imagen al bufer con tamanio y color ARGB
        graPixel = buffer.createGraphics();//almacenar el pixel
        dibujaLinea(0, 100, 200, 125, buffer);//metodo con las coordenadas y el buffer
        g.drawImage(buffer, 0, 0, this);//metodo grafico de tipo draw imagen  con parametro buffer
    }

    public void dibujaLinea(int Xo, int Yo , int Xf, int Yf, BufferedImage buf) {
        Color c = Color.black;//Color
        System.out.println("Xo:" + Xo + "\nXf:" + Xf + "\nYo:" + "\nYf:" + Yf);
        float ca = Float.max(Xo, Xf) - Float.min(Xo, Xf);//redondea el valor y lo resta mayor menos el menor
        float co =  Float.max(Yo, Yf) - Float.min(Yo, Yf);//redondea el valor y lo resta mayor menos el menor
        float hip = co / ca;//sacar la pendiente usando formula matematica
        System.out.println("Adyasente: "+ ca + "\nOpuesto: " + co + "\nPendiente: " + hip);
        int sigX = 0;//Inicializar
        int sigY = 0;//Inicializar
        hip = Math.abs(hip);//valor absoluto (positivo)

        if (Xo < Xf) {
            sigX = 1;
        } else {
            sigX = -1;
        }
        if (Yo < Yf) {
            sigY = 1;
        } else {
            sigY = -1;
        }

        if (Math.toDegrees(Math.atan(hip)) > 45) {//se tomo el arco tangente de lapendiente y se convierte en radianes y se evalua
            hip = Math.abs(ca / co);//la pendiente ahora es CA/CO
            for (int i = 0; i <= Math.abs(co); i++) {//ciclo
                buf.setRGB(Xo + (int) (i * hip * sigX), Yo + (i * sigY), c.getRGB());//se descarga el bufer en las cordenas
            }
        } else {
            for (int h = 0; h <= Math.abs(ca); h++) {
                buf.setRGB(Xo + h * sigX, Yo + (int) (h * hip * sigY), c.getRGB());//descargar buffer
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
